import React, { useState, useEffect } from "react";
import { porudzbinaApi } from "../services/api";

function Porudzbine() {
  const [porudzbine, setPorudzbine] = useState([]);

  useEffect(() => {
    ucitajMojePorudzbine();
  }, []);

  const ucitajMojePorudzbine = async () => {
    try {
      const korisnik = JSON.parse(localStorage.getItem("korisnik") || "{}");
      const korisnikID = korisnik.korisnikID; 
      console.log(korisnik);
      if (!korisnikID) return;
      const response = await porudzbinaApi.getPoKorisniku(korisnikID);
      setPorudzbine(Array.isArray(response.data) ? response.data : []);
    } catch (error) {
      console.error("Greška pri učitavanju porudžbina:", error);
      setPorudzbine([]);
    }
  };

  const otkaziPorudzbinu = async (porudzbinaId) => {
    if (window.confirm("Da li ste sigurni da želite da otkažete ovu porudžbinu?")) {
      try {
        await porudzbinaApi.otkazi(porudzbinaId);
        alert("Porudžbina je uspešno otkazana.");
        ucitajMojePorudzbine();
      } catch (error) {
        alert(error.response?.data?.greska || "Greška pri otkazivanju porudžbine.");
      }
    }
  };

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
      borderBottom: "1px solid #29292e",
      paddingBottom: "20px",
    },
    mainHeader: {
      fontSize: "26px",
      fontWeight: "700",
      letterSpacing: "-0.5px",
      color: "#2ea043",
      margin: 0,
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
    btnCancel: { 
      padding: "6px 12px", 
      backgroundColor: "rgba(247, 94, 94, 0.1)", 
      color: "#f75e5e", 
      border: "1px solid rgba(247, 94, 94, 0.2)", 
      borderRadius: "0px",
      fontSize: "12px", 
      fontWeight: "600", 
      cursor: "pointer" 
    },
    noData: {
      textAlign: "center",
      padding: "40px",
      color: "#82828e",
      fontSize: "14px",
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.headerWrapper}>
        <h2 style={styles.mainHeader}>Moje porudžbine</h2>
      </div>

      <div style={styles.tableContainer}>
        {porudzbine.length === 0 ? (
          <div >Nemate kreiranih porudžbina.</div>
        ) : (
          <table style={styles.table}>
            <thead>
              <tr>
                <th style={styles.th}>ID Porudžbine</th>
                <th style={styles.th}>Datum</th>
                <th style={styles.th}>Status</th>
                <th style={styles.th}>Stavke porudžbine</th>
                <th style={styles.th}>Ukupan iznos</th>
                <th style={styles.th}>Akcije</th>
              </tr>
            </thead>
            <tbody>
              {porudzbine.map((p) => {
                const mozeSeOtkazati = p.statusPorudzbine === "KREIRANA";
                return (
                  <tr key={p.porudzbinaID}>
                    <td style={styles.td}>#{p.porudzbinaID}</td>
                    <td style={styles.td}>{p.datum || "N/A"}</td>
                    <td style={styles.td}>
                      <span style={{ fontWeight: "600", color: "#e1e1e6" }}>
                        {p.statusPorudzbine}
                      </span>
                    </td>
                    <td style={styles.td}>
                      {p.stavke && p.stavke.length > 0 ? (
                        p.stavke.map((s, index) => (
                          <div key={index} style={{ marginBottom: "8px", fontSize: "12px" }}>
                            <span>{s.nazivKnjige || s.knjiga?.naziv || "Knjiga"} (Količina: {s.kolicina})</span>
                            <br />
                            <span style={{ color: "#82828e" }}>{s.jedinicnaCena} RSD/kom — Ukupno: {s.kolicina * s.jedinicnaCena} RSD</span>
                          </div>
                        ))
                      ) : (
                        <span style={{ fontSize: "12px", color: "#82828e" }}>Nema stavki.</span>
                      )}
                    </td>
                    <td style={styles.td}>{p.ukupanIznos} RSD</td>
                    <td style={styles.td}>
                      {mozeSeOtkazati && (
                        <button onClick={() => otkaziPorudzbinu(p.porudzbinaID)} style={styles.btnCancel}>
                          Otkaži
                        </button>
                      )}
                    </td>
                  </tr>
                );
              })}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}

export default Porudzbine;