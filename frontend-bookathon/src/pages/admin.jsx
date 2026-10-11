import React, { useState, useEffect } from "react";
import { knjigaApi, porudzbinaApi, otpremnicaApi, izdavackaKucaApi } from "../services/api";

function Admin() {
  const korisnikTrenutni = JSON.parse(localStorage.getItem("korisnik") || "{}");
  const jeAdmin = korisnikTrenutni.uloga === "ADMIN";

  const [aktivnaSekcija, setAktivnaSekcija] = useState("knjige");

  const [knjige, setKnjige] = useState([]);

  const [porudzbine, setPorudzbine] = useState([]);
  const [otpremnice, setOtpremnice] = useState([]);
  const [izdavackeKuce, setIzdavackeKuce] = useState([]);


  const [otvorenaPorudzbina, setOtvorenaPorudzbina] = useState(null);

  const [novaKnjiga, setNovaKnjiga] = useState({ 
    naziv: "", 
    autor: "", 
    opis: "", 
    slika: "", 
    cena: "", 
    stanje: "", 
    datum: "", 
    izdavackaKucaID: "",
    rezervisanoStanje: 0 
  });
  
  const [izmenaKnjiga, setIzmenaKnjiga] = useState(null);
  const [otpremnicaStavke, setOtpremnicaStavke] = useState({});

  const [filterStatus, setFilterStatus] = useState("");
  const [filterOtpremnica, setFilterOtpremnica] = useState("");

  useEffect(() => {
    if (!jeAdmin) {
      alert("Nemate pristup ovoj stranici!");
      window.location.href = "/";
      return;
    }
    loadAll();
  }, []);

  const loadAll = async () => {
    try {
      const resKnjige = await knjigaApi.getAll();
      setKnjige(Array.isArray(resKnjige.data) ? resKnjige.data : []);
    } catch (error) {
      console.error("Greška pri učitavanju knjiga:", error);
      setKnjige([]);
    }

    try {
      const resIzdavaci = await izdavackaKucaApi.getAll();
      setIzdavackeKuce(Array.isArray(resIzdavaci.data) ? resIzdavaci.data : []);
   } catch (error) {
      console.error("Greška pri učitavanju izdavačkih kuća:", error);
      setIzdavackeKuce([]);
 }

    try {
      const resPorudzbine = await porudzbinaApi.getAll();
      setPorudzbine(Array.isArray(resPorudzbine.data) ? resPorudzbine.data : []);
            } catch (error) {
      console.error("Greška pri učitavanju porudžbina:", error);
      setPorudzbine([]);
        }

    try {
      const resOtpremnice = await otpremnicaApi.getAll();
         setOtpremnice(Array.isArray(resOtpremnice.data) ? resOtpremnice.data : []);
      } catch (error) {
           console.error("Greška pri učitavanju otpremnica:", error);
           setOtpremnice([]);
    }
  };

  const proveriPoljaKnjige = (knjiga) => {
    if (!knjiga.naziv || knjiga.naziv.trim() === "") return "Naziv je obavezan!";
    if (!knjiga.autor || knjiga.autor.trim() === "") return "Autor je obavezan!";
    if (!knjiga.opis || knjiga.opis.trim() === "") return "Opis je obavezan!";
    
    if (!knjiga.slika || knjiga.slika.trim() === "") return "URL slike je obavezan!";
    if (knjiga.cena === "" || knjiga.cena === null || parseFloat(knjiga.cena) <= 0) return "Cena mora biti veća od nule!";
    if (knjiga.stanje === "" || knjiga.stanje === null || parseInt(knjiga.stanje) < 0) return "Stanje mora biti uneto (0 ili više)!";
    if (!knjiga.datum || knjiga.datum.trim() === "") return "Datum je obavezan!";
    if (!knjiga.izdavackaKucaID || knjiga.izdavackaKucaID === "") return "Izdavačka kuća je obavezna!";
    return null;
  };

  const dodajKnjigu = async () => {
    const greska = proveriPoljaKnjige(novaKnjiga);
    if (greska) {
      alert(greska);
      return;
    }

    try {
      await knjigaApi.save({
        ...novaKnjiga,
        cena: parseFloat(novaKnjiga.cena),
        stanje: parseInt(novaKnjiga.stanje),
        rezervisanoStanje: 0,
        izdavackaKucaID: parseInt(novaKnjiga.izdavackaKucaID),
      });
      alert("Knjiga je uspešno dodata!");
      setNovaKnjiga({ naziv: "", autor: "", opis: "", slika: "", cena: "", stanje: "", datum: "", izdavackaKucaID: "", rezervisanoStanje: 0 });
      loadAll();
    } catch (error) {
      alert(error.response?.data?.greska || "Greška pri dodavanju knjige.");
    }
  };

  const sacuvajIzmenuKnjige = async () => {
    const greska = proveriPoljaKnjige(izmenaKnjiga);
    if (greska) {
      alert(greska);
      return;
    }

    try {
      await knjigaApi.update(izmenaKnjiga.knjigaID, {
        ...izmenaKnjiga,
        cena: parseFloat(izmenaKnjiga.cena),
        stanje: parseInt(izmenaKnjiga.stanje),
        izdavackaKucaID: parseInt(izmenaKnjiga.izdavackaKucaID),
      });
      alert("Knjiga izmenjena!");
      setIzmenaKnjiga(null);
      loadAll();
    } catch (error) {
      alert(error.response?.data?.greska || "Greška pri izmeni.");
    }
  };

  const obrisiKnjigu = async (id) => {
    if (window.confirm("Obrisati knjigu?")) {
      try {
        await knjigaApi.delete(id);
        setIzmenaKnjiga(null);
        loadAll();
      } catch (error) {
        alert("Ne može se obrisati (postoje zavisnosti).");
      }
    }
  };

  const prikaziDetalje = (porudzbinaId) => {
    setOtvorenaPorudzbina(otvorenaPorudzbina === porudzbinaId ? null : porudzbinaId);
    setOtpremnicaStavke({});
  };

  const storniraOtpremnicu = async (id) => {
    if (window.confirm("Stornirati ovu otpremnicu? Stanje knjiga će biti vraćeno, kupac će dobiti obaveštenje na mejl.")) {
      try {
        await otpremnicaApi.storniraj(id);
        alert("Otpremnica je stornirana, stanje je vraćeno.");
        loadAll();
      } catch (error) {
        alert(error.response?.data?.greska || "Greška pri storniranju.");
      }
    }
  };

  const otkaziPorudzbinu = async (porudzbinaId) => {
    if (window.confirm("Otkazati ovu porudžbinu?")) {
      try {
        await porudzbinaApi.otkazi(porudzbinaId);
        alert("Porudžbina je otkazana.");
        loadAll();
      } catch (error) {
        alert("Greška pri otkazivanju.");
      }
    }
  };

  const promeniKolicinaZaSlanje = (knjigaId, kolicina) => {
    setOtpremnicaStavke({ ...otpremnicaStavke, [knjigaId]: kolicina });
  };

  const izracunajIsporuceno = (porudzbinaId, knjigaId) => {
    if (!Array.isArray(otpremnice)) return 0;
    return otpremnice
      .filter((o) => o.porudzbinaID === porudzbinaId && o.statusOtpremnice === "IZDATA")
      .flatMap((o) => o.stavke || [])
      .filter((s) => s.knjigaID === knjigaId)
      .reduce((sum, s) => sum + s.kolicina, 0);
  };

  const generisiOtpremnicu = async (porudzbinaID, stavkePorudzbine) => {
    const stavke = (stavkePorudzbine || [])
      .map((s) => ({
        knjigaID: s.knjigaID,
        kolicina: parseInt(otpremnicaStavke[s.knjigaID]) || 0,
      }))
      .filter((s) => s.kolicina > 0);

    if (stavke.length === 0) {
      alert("Unesite bar jednu količinu za slanje.");
      return;
    }

    try {
      const response = await otpremnicaApi.generisi({ porudzbinaID, stavke });
      alert("Otpremnica generisana! Broj: " + response.data.brojOtpremnice);
      setOtpremnicaStavke({});
      loadAll();
    } catch (error) {
      alert(error.response?.data?.greska || "Greška pri generisanju otpremnice.");
    }
  };

  const filtriranePorudzbine = (Array.isArray(porudzbine) ? porudzbine : []).filter((p) => {
    return !filterStatus || p.statusPorudzbine === filterStatus;
  });

  const filtriraneOtpremnice = (Array.isArray(otpremnice) ? otpremnice : []).filter((o) =>
    !filterOtpremnica || (o.brojOtpremnice || "").toLowerCase().includes(filterOtpremnica.toLowerCase())
  );

  const styles = {
    container: {
      minHeight: "100vh",
      backgroundColor: "#121214",
      color: "#e1e1e6",
      paddingTop: "100px",
      paddingBottom: "50px",
      paddingLeft: "30px",
      paddingRight: "30px",
      fontFamily: "'Inter', system-ui, -apple-system, sans-serif",
    },
    headerWrapper: {
      display: "flex",
      justifyContent: "space-between",
      alignItems: "center",
      marginBottom: "30px",
      paddingBottom: "20px",
    },
    mainHeader: {
      fontSize: "26px",
      fontWeight: "700",
      letterSpacing: "-0.5px",
      color: "#2ea043",
      margin: 0,
    },
    navTabs: {
      display: "flex",
      gap: "20px",
    },
    tabBtn: {
      padding: "10px 4px",
      backgroundColor: "transparent",
      color: "#a8a8b3",
      border: "none",
      borderBottom: "2px solid transparent",
      borderRadius: "0px",
      fontSize: "14px",
      fontWeight: "600",
      cursor: "pointer",
      transition: "all 0.2s ease",
    },
    layoutGrid: {
      display: "grid",
      gridTemplateColumns: "340px 1fr",
      gap: "30px",
      alignItems: "start",
    },
    fullWidthGrid: {
      display: "grid",
      gridTemplateColumns: "1fr",
      gap: "30px",
    },
    formBox: {
      backgroundColor: "#202024",
      border: "1px solid #29292e",
      borderRadius: "0px",
      padding: "24px",
      boxShadow: "0 8px 24px rgba(0, 0, 0, 0.4)",
    },
    formHeader: {
      fontSize: "16px",
      fontWeight: "600",
      color: "#e1e1e6",
      margin: "0 0 20px 0",
    },
    inputGroup: { 
      marginBottom: "14px" 
    },
    label: { 
      display: "block", 
      fontSize: "12px", 
      fontWeight: "500", 
      color: "#a8a8b3", 
      marginBottom: "6px" 
    },
    input: { 
      width: "100%", 
      padding: "12px 14px", 
      fontSize: "14px", 
      backgroundColor: "#121214", 
      border: "1px solid #29292e", 
      borderRadius: "0px",
      color: "#e1e1e6",
      boxSizing: "border-box",
      outline: "none",
    },
    btnPrimary: { 
      width: "100%", 
      padding: "12px", 
      backgroundColor: "#2ea043",
      color: "#ffffff", 
      border: "none", 
      borderRadius: "0px",
      fontSize: "13px", 
      fontWeight: "700", 
      cursor: "pointer", 
      marginTop: "10px",
      transition: "background 0.2s",
    },
    btnSecondary: {
      width: "100%",
      padding: "10px",
      backgroundColor: "transparent",
      color: "#a8a8b3",
      border: "1px solid #29292e",
      borderRadius: "0px",
      fontSize: "13px",
      fontWeight: "600",
      cursor: "pointer",
      marginTop: "8px",
    },
    tableContainer: { 
      backgroundColor: "#202024", 
      border: "1px solid #29292e", 
      borderRadius: "0px",
      padding: "24px", 
      boxShadow: "0 8px 24px rgba(0, 0, 0, 0.4)" 
    },
    table: { 
      width: "100%", 
      borderCollapse: "collapse", 
      marginTop: "10px" 
    },
    th: { 
      padding: "14px 16px", 
      backgroundColor: "#18181b", 
      color: "#82828e", 
      fontSize: "11px", 
      fontWeight: "700", 
      textTransform: "uppercase", 
      textAlign: "left",
      borderBottom: "1px solid #29292e",
    },
    td: { 
      padding: "14px 16px", 
      borderBottom: "1px solid #29292e", 
      fontSize: "13px",
      color: "#e1e1e6",
    },
    btnEdit: { 
      padding: "6px 12px", 
      backgroundColor: "rgba(46, 160, 67, 0.1)", 
      color: "#2ea043", 
      border: "1px solid rgba(46, 160, 67, 0.2)", 
      borderRadius: "0px",
      fontSize: "12px", 
      fontWeight: "600", 
      cursor: "pointer", 
    },
    btnDelete: { 
      padding: "6px 12px", 
      backgroundColor: "rgba(247, 94, 94, 0.1)", 
      color: "#f75e5e", 
      border: "1px solid rgba(247, 94, 94, 0.2)", 
      borderRadius: "0px",
      fontSize: "12px", 
      fontWeight: "600", 
      cursor: "pointer" 
    },
  };

  return (
    <div style={styles.container}>
      {!jeAdmin ? null : (
        <>
          <div style={styles.headerWrapper}>
            <h2 style={styles.mainHeader}>Admin Panel</h2>
            <div style={styles.navTabs}>
              <button style={styles.tabBtn} onClick={() => setAktivnaSekcija("knjige")}>
                Knjige
              </button>
              <button style={styles.tabBtn} onClick={() => setAktivnaSekcija("porudzbine")}>
                Porudžbine
              </button>
              <button style={styles.tabBtn} onClick={() => setAktivnaSekcija("otpremnice")}>
                Otpremnice
              </button>
            </div>
          </div>

          {/* Sekcija: Knjige */}
          {aktivnaSekcija === "knjige" && (
            <div style={styles.layoutGrid}>
              {!izmenaKnjiga ? (
                <div style={styles.formBox}>
                  <h3 style={styles.formHeader}>Dodaj novu knjigu</h3>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Naziv</label>
                    <input value={novaKnjiga.naziv} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, naziv: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Autor</label>
                    <input value={novaKnjiga.autor} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, autor: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Opis</label>
                    <input value={novaKnjiga.opis} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, opis: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>URL slike</label>
                    <input value={novaKnjiga.slika} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, slika: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Cena (RSD)</label>
                    <input type="number" value={novaKnjiga.cena} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, cena: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Stanje</label>
                    <input type="number" value={novaKnjiga.stanje} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, stanje: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Datum</label>
                    <input type="date" value={novaKnjiga.datum} onChange={(e) => setNovaKnjiga({ ...novaKnjiga, datum: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Izdavačka kuća</label>
                    <select 
                      value={novaKnjiga.izdavackaKucaID} 
                      onChange={(e) => setNovaKnjiga({ ...novaKnjiga, izdavackaKucaID: e.target.value })} 
                      style={styles.input}
                    >
                      <option value="">Izaberite izdavačku kuću</option>
                      {izdavackeKuce.map((ikuća) => (
                        <option key={ikuća.izdavackaKucaID} value={ikuća.izdavackaKucaID} style={{ background: "#121214" }}>
                          {ikuća.naziv}
                        </option>
                      ))}
                    </select>
                  </div>
                  <button onClick={dodajKnjigu} style={styles.btnPrimary}>Sačuvaj knjigu</button>
                </div>
              ) : (
                <div style={styles.formBox}>
                  <h3 style={styles.formHeader}>Izmeni knjigu</h3>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Naziv</label>
                    <input value={izmenaKnjiga.naziv || ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, naziv: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Autor</label>
                    <input value={izmenaKnjiga.autor || ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, autor: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Opis</label>
                    <input value={izmenaKnjiga.opis || ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, opis: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>URL slike</label>
                    <input value={izmenaKnjiga.slika || ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, slika: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Cena (RSD)</label>
                    <input type="number" value={izmenaKnjiga.cena || ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, cena: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Stanje</label>
                    <input type="number" value={izmenaKnjiga.stanje ?? ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, stanje: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Datum</label>
                    <input type="date" value={izmenaKnjiga.datum || ""} onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, datum: e.target.value })} style={styles.input} />
                  </div>
                  <div style={styles.inputGroup}>
                    <label style={styles.label}>Izdavačka kuća</label>
                    <select 
                      value={izmenaKnjiga.izdavackaKucaID || ""} 
                      onChange={(e) => setIzmenaKnjiga({ ...izmenaKnjiga, izdavackaKucaID: e.target.value })} 
                      style={styles.input}
                    >
                      <option value="">Izaberite izdavačku kuću</option>
                      {izdavackeKuce.map((ikuća) => (
                        <option key={ikuća.izdavackaKucaID} value={ikuća.izdavackaKucaID} style={{ background: "#121214" }}>
                          {ikuća.naziv}
                        </option>
                      ))}
                    </select>
                  </div>
                  <button onClick={sacuvajIzmenuKnjige} style={styles.btnPrimary}>Sačuvaj izmene</button>
                  <div style={{ display: "flex", gap: "10px", marginTop: "8px" }}>
                    <button onClick={() => obrisiKnjigu(izmenaKnjiga.knjigaID)} style={{ ...styles.btnDelete, flex: 1, padding: "10px" }}>Obriši knjigu</button>
                    <button onClick={() => setIzmenaKnjiga(null)} style={{ ...styles.btnSecondary, flex: 1, marginTop: 0 }}>Otkaži</button>
                  </div>
                </div>
              )}

              <div style={styles.tableContainer}>
                <h3 style={styles.formHeader}>Lista knjiga</h3>
                <table style={styles.table}>
                  <thead>
                    <tr>
                      <th style={styles.th}>Naziv</th>
                      <th style={styles.th}>Autor</th>
                      <th style={styles.th}>Cena</th>
                      <th style={styles.th}>Stanje</th>
                      <th style={styles.th}>Akcija</th>
                    </tr>
                  </thead>
                  <tbody>
                    {knjige.map((k) => (
                      <tr key={k.knjigaID}>
                        <td style={styles.td}>{k.naziv}</td>
                        <td style={styles.td}>{k.autor}</td>
                        <td style={styles.td}>{k.cena} RSD</td>
                        <td style={styles.td}>{k.stanje}</td>
                        <td style={styles.td}>
                          <button onClick={() => setIzmenaKnjiga(k)} style={styles.btnEdit}>Izmeni</button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* Sekcija: Porudžbine */}
          {aktivnaSekcija === "porudzbine" && (
            <div style={styles.fullWidthGrid}>
              <div style={styles.tableContainer}>
                <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: "20px" }}>
                  <h3 style={styles.formHeader}>Sve porudžbine</h3>
                  <select value={filterStatus} onChange={(e) => setFilterStatus(e.target.value)} style={{ ...styles.input, maxWidth: "220px", margin: 0 }}>
                    <option value="">Svi statusi</option>
                    <option value="KREIRANA">KREIRANA</option>
                    <option value="PARCIJALNO_ISPORUCENA">PARCIJALNO_ISPORUCENA</option>
                    <option value="ISPORUCENA">ISPORUCENA</option>
                    <option value="OTKAZANA">OTKAZANA</option>
                  </select>
                </div>
                <table style={styles.table}>
                  <thead>
                    <tr>
                      <th style={styles.th}>ID</th>
                      <th style={styles.th}>Kupac</th>
                      <th style={styles.th}>Status</th>
                      <th style={styles.th}>Iznos</th>
                      <th style={styles.th}>Akcije</th>
                    </tr>
                  </thead>
                  <tbody>
                    {filtriranePorudzbine.map((p) => {
                      const jeZavrsenaIliOtkazana = p.statusPorudzbine === "ISPORUCENA" || p.statusPorudzbine === "OTKAZANA";
                      return (
                        <React.Fragment key={p.porudzbinaID}>
                          <tr>
                            <td style={styles.td}>#{p.porudzbinaID}</td>
                            <td style={styles.td}>{p.KupacUsername}</td>
                            <td style={styles.td}>{p.statusPorudzbine}</td>
                            <td style={styles.td}>{p.ukupanIznos} RSD</td>
                            <td style={styles.td}>
                              <button onClick={() => prikaziDetalje(p.porudzbinaID)} style={styles.btnEdit}>
                                {otvorenaPorudzbina === p.porudzbinaID ? "Sakrij" : "Prikaži"}
                              </button>
                              {p.statusPorudzbine !== "OTKAZANA" && p.statusPorudzbine !== "ISPORUCENA" && (
                                <button onClick={() => otkaziPorudzbinu(p.porudzbinaID)} style={styles.btnDelete}>
                                  Otkaži
                                </button>
                              )}
                            </td>
                          </tr>
                          {otvorenaPorudzbina === p.porudzbinaID && (
                            <tr>
                              <td colSpan="5" style={{ ...styles.td, backgroundColor: "#18181b" }}>
                                <p style={{ fontWeight: "600", marginBottom: "12px", color: "#2ea043" }}>Naručene stavke i generisanje otpremnice:</p>
                                {p.stavke && p.stavke.map((s) => {
                                  const isporuceno = izracunajIsporuceno(p.porudzbinaID, s.knjigaID);
                                  return (
                                    <div key={s.rb || s.knjigaID} style={{ display: "flex", alignItems: "center", gap: "12px", marginBottom: "10px" }}>
                                      <span style={{ flex: 1, fontSize: "12px" }}>
                                        {s.nazivKnjige || s.knjiga?.naziv} — naručeno: {s.kolicina} kom, isporučeno: {isporuceno} kom, {s.jedinicnaCena} RSD/kom
                                      </span>
                                      <input
                                        type="number"
                                        placeholder="Kol. za slanje"
                                        min={0}
                                        disabled={jeZavrsenaIliOtkazana}
                                        style={{ ...styles.input, width: "130px", padding: "8px" }}
                                        onChange={(e) => promeniKolicinaZaSlanje(s.knjigaID, e.target.value)}
                                      />
                                    </div>
                                  );
                                })}
                                <button
                                  onClick={() => generisiOtpremnicu(p.porudzbinaID, p.stavke)}
                                  disabled={jeZavrsenaIliOtkazana}
                                  style={{
                                    ...styles.btnPrimary,
                                    maxWidth: "280px",
                                    ...(jeZavrsenaIliOtkazana ? { backgroundColor: "#29292e", color: "#82828e", cursor: "not-allowed" } : {}),
                                  }}
                                >
                                  {p.statusPorudzbine === "ISPORUCENA" 
                                    ? "Porudžbina je isporučena" 
                                    : p.statusPorudzbine === "OTKAZANA" 
                                    ? "Porudžbina je otkazana" 
                                    : "Generiši otpremnicu"}
                                </button>
                              </td>
                            </tr>
                          )}
                        </React.Fragment>
                      );
                    })}
                  </tbody>
                </table>
              </div>
            </div>
          )}

          {/* Sekcija: Otpremnice */}
          {aktivnaSekcija === "otpremnice" && (
            <div style={styles.fullWidthGrid}>
              <div style={styles.tableContainer}>
                <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center", marginBottom: "20px" }}>
                  <h3 style={styles.formHeader}>Sve otpremnice</h3>
                  <input
                    placeholder="Pretraga po broju otpremnice..."
                    value={filterOtpremnica}
                    onChange={(e) => setFilterOtpremnica(e.target.value)}
                    style={{ ...styles.input, maxWidth: "260px", margin: 0 }}
                  />
                </div>
                <table style={styles.table}>
                  <thead>
                    <tr>
                      <th style={styles.th}>Broj</th>
                      <th style={styles.th}>Datum</th>
                      <th style={styles.th}>Porudžbina</th>
                      <th style={styles.th}>Status</th>
                      <th style={styles.th}>Iznos</th>
                      <th style={styles.th}>Akcije</th>
                    </tr>
                  </thead>
                  <tbody>
                    {filtriraneOtpremnice.map((o) => (
                      <tr key={o.otpremnicaID}>
                        <td style={styles.td}>{o.brojOtpremnice}</td>
                        <td style={styles.td}>{o.datum}</td>
                        <td style={styles.td}>#{o.porudzbinaID}</td>
                        <td style={styles.td}>{o.statusOtpremnice}</td>
                        <td style={styles.td}>{o.iznos} RSD</td>
                        <td style={styles.td}>
                          {o.statusOtpremnice !== "STORNIRANA" && (
                            <button onClick={() => storniraOtpremnicu(o.otpremnicaID)} style={styles.btnDelete}>
                              Storniraj
                            </button>
                          )}
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          )}
        </>
      )}
    </div>
  );
}

export default Admin;