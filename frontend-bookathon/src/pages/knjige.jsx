import React, { useState, useEffect } from "react";

import { knjigaApi } from "../services/api";
import {  useNavigate,Link } from "react-router-dom";

function Proizvodi() {
  const [knjige, setKnjige] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
    const navigate = useNavigate();

  const otvoriRecenzije = (knjigaId) => {
    localStorage.setItem("selectedKnjigaId", knjigaId);
    navigate("/recenzije");
  };
  useEffect(() => {
    ucitaj();
  }, []);

  const ucitaj = async () => {
    try {
      const response = await knjigaApi.getAll();
      setKnjige(response.data);
    } catch (error) {
      console.error("Greška prilikom učitavanja knjiga:", error);
    }
  };

  const dodajUKorpu = (knjiga) => {
    
    if (knjiga.stanje !== undefined && knjiga.stanje <= 0) {
    alert("Knjiga trenutno nije na stanju!");
    return;
  }

  const unos = prompt("Unesite količinu:", "1");

  if (unos === null) {
    return;
  }

  const kolicina = parseInt(unos, 10);

  if (isNaN(kolicina) || kolicina <= 0) {
    alert("Unesite validnu količinu!");
    return;
  }

  const korpa = JSON.parse(localStorage.getItem("korpa") || "[]");
  const knjigaId = knjiga.knjigaID || knjiga.id;

  const postojeci = korpa.find((item) => item.proizvodId === knjigaId);

  if (postojeci) {
    postojeci.kolicina += kolicina;
  } else {
    korpa.push({
      proizvodId: knjigaId,
      naziv: knjiga.naziv,
      autor: knjiga.autor ,
      opis: knjiga.opis,
      cena: knjiga.cena,
      kolicina: kolicina,
    });
  }

  localStorage.setItem("korpa", JSON.stringify(korpa));
  alert("Knjiga je dodata u korpu!");
  };

  const filtriraneKnjige = knjige.filter(
    (k) =>
      (k.naziv || "").toLowerCase().includes(searchTerm.toLowerCase()) ||
      (k.autor || "").toLowerCase().includes(searchTerm.toLowerCase()) ||
      (k.opis || "").toLowerCase().includes(searchTerm.toLowerCase())
  );

  return (
    <div style={styles.container}>
      <div style={styles.headerContainer}>
        <div>
          <h2 style={styles.header}>Katalog knjiga</h2>
         
        </div>
        <input
          type="text"
          placeholder="Pretraga"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          style={styles.searchInput}
        />
      </div>

      <div style={styles.grid}>
        {filtriraneKnjige.map((knjiga, idx) => {
          const knjigaId = knjiga.knjigaID ;
          const rasprodato =  knjiga.stanje <= 0;

          return (
            <div key={knjigaId} style={styles.card}>
              <div style={styles.imageWrapper}>
                <img
                  src={knjiga.slika || "/images/book-placeholder.jpg"}
                  alt={knjiga.naziv}
                  style={styles.image}
                  onError={(e) => {
                    e.target.onerror = null;
                    e.target.src = "/images/book-placeholder.jpg";
                  }}
                />
              </div>

              <div style={styles.cardContent}>
                <h3 style={styles.title}>{knjiga.naziv}</h3>
                <p style={styles.author}>
                   {knjiga.autor || "Nepoznati autor"}
                </p>
                <p style={styles.desc}>
                  {knjiga.opis || "Nema opisa za ovu knjigu."}
                </p>

                <div style={styles.footerRow}>
                  <div style={styles.priceRow}>
                    <span style={styles.price}>
                      {knjiga.cena} { "RSD"}
                    </span>
                  </div>

                  <button
                    onClick={() => dodajUKorpu(knjiga)}
                    disabled={rasprodato}
                    style={{
                      ...styles.btn,
                      ...(rasprodato ? styles.btnDisabled : {}),
                    }}
                  >
                    {rasprodato ? "Nema na stanju" : "Dodaj u korpu"}
                  </button>
                  <button
      onClick={() => otvoriRecenzije(knjigaId)}
      style={{ ...styles.btn, backgroundColor: "#21262d" }}
    >
      Vidi Recenzije
    </button>
                    
                  





                </div>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}

const styles = {
  container: {
    minHeight: "100vh",
    backgroundColor: "#0d1117",
    paddingTop: "100px",
    paddingBottom: "60px",
    paddingLeft: "40px",
    paddingRight: "40px",
    fontFamily:
      '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    boxSizing: "border-box",
  },
  headerContainer: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: "36px",
    flexWrap: "wrap",
    gap: "16px",
    maxWidth: "5200px",
    // margin: "0 auto 36px auto",
  },
  header: {
    fontSize: "32px",
    fontWeight: "800",
    margin: "0 0 6px 0",
    color: "#ffffff",
  },
  subHeader: {
    fontSize: "14px",
    color: "#8b949e",
    margin: 0,
  },
  searchInput: {
    padding: "12px 18px",
    fontSize: "14px",
    backgroundColor: "#161b22",
    color: "#ffffff",
    border: "1px solid #30363d",
    
    width: "100%",
    maxWidth: "180px",
    outline: "none",
    boxSizing: "border-box",
  },
  grid: {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(260px, 1fr))",
    gap: "24px",
    maxWidth: "1200px",
    margin: "0 auto",
  },
  card: {
    backgroundColor: "#161b22",
    border: "1px solid rgba(255, 255, 255, 0.08)",
    borderRadius: "12px",
    overflow: "hidden",
    display: "flex",
    flexDirection: "column",
  },
  imageWrapper: {
    width: "100%",
    height: "320px",
    backgroundColor: "#0d1117",
  },
  image: {
    width: "100%",
    height: "100%",
    objectFit: "cover",
  },
  cardContent: {
    padding: "20px",
    display: "flex",
    flexDirection: "column",
    flexGrow: 1,
  },
  title: {
    fontSize: "18px",
    fontWeight: "700",
    margin: "0 0 4px 0",
    color: "#ffffff",
    lineHeight: "1.3",
  },
  author: {
    fontSize: "13px",
    fontWeight: "600",
    color: "#2ea043",
    margin: "0 0 12px 0",
  },
  desc: {
    fontSize: "13px",
    color: "#8b949e",
    lineHeight: "1.5",
    margin: "0 0 20px 0",
    flexGrow: 1,
  },
  footerRow: {
    display: "flex",
    flexDirection: "column",
    gap: "12px",
    marginTop: "auto",
  },
  priceRow: {
    display: "flex",
    alignItems: "baseline",
    gap: "8px",
  },
  price: {
    fontSize: "20px",
    fontWeight: "800",
    color: "#ffffff",
  },
  btn: {
    width: "100%",
    padding: "12px",
    backgroundColor: "#238636",
    color: "#ffffff",
    border: "none",
    borderRadius: "8px",
    fontSize: "13px",
    fontWeight: "600",
    cursor: "pointer",
  },
  btnDisabled: {
    backgroundColor: "#21262d",
    color: "#484f58",
    cursor: "not-allowed",
  },
};

export default Proizvodi;