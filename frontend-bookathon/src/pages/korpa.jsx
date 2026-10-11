import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { porudzbinaApi } from "../services/api";
function Korpa() {
  const [korpa, setKorpa] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    ucitajKorpu();
  }, []);

  const napraviPorudzbinu = async () => {
 
  const korisnik = JSON.parse(localStorage.getItem("korisnik") || "{}");
  if (!korisnik.username) {
    alert("Morate biti ulogovani da biste napravili porudžbinu.");
    return;
  }
console.log("Ulogovani korisnik:", korisnik);
const idKorisnika=korisnik.korisnikID;
  const porudzbinaDTO = {
    userID: idKorisnika,
    stavke: korpa.map((s) => ({
      knjigaID: s.proizvodId ,
      jedinicnaCena:s.cena,
      kolicina: s.kolicina,
    })),
  };
  try {
    await porudzbinaApi.create(porudzbinaDTO);
    alert("Porudžbina je uspešno kreirana!");
    
    
    localStorage.removeItem("korpa"); 
  } catch (error) {
    console.error("Greška pri kreiranju porudžbine:", error);
    alert(error.response.data.message || error.response?.data || "Greška pri kreiranju porudžbine.");
  }

};

  const ucitajKorpu = () => {
    const sacuvanaKorpa = JSON.parse(localStorage.getItem("korpa") || "[]");
    setKorpa(sacuvanaKorpa);
  };

  const izmeniKolicinu = (proizvodId, novaKolicina) => {
    if (novaKolicina <= 0) {
      ukloniIzKorpe(proizvodId);
      return;
    }
    const korisnik = JSON.parse(localStorage.getItem("korisnik") || "{}");
console.log("Ulogovani korisnik ID:", korisnik.korisnikID);
    const izmenjenaKorpa = korpa.map((item) =>
      item.proizvodId === proizvodId ? { ...item, kolicina: novaKolicina } : item
    );

    setKorpa(izmenjenaKorpa);
    localStorage.setItem("korpa", JSON.stringify(izmenjenaKorpa));
  };

  const ukloniIzKorpe = (proizvodId) => {
    const novaKorpa = korpa.filter((item) => item.proizvodId !== proizvodId);
    setKorpa(novaKorpa);
    localStorage.setItem("korpa", JSON.stringify(novaKorpa));
  };

  const prazniKorpu = () => {
    setKorpa([]);
    localStorage.removeItem("korpa");
  };

  const ukupanIznos = korpa.reduce(
    (sum, item) => sum + item.cena * item.kolicina,
    0
  );

  return (
    <div style={styles.container}>
      

      <div style={styles.headerRow}>
        <h2 style={styles.title}>Vaša korpa</h2>
        {korpa.length > 0 && (
          <button onClick={prazniKorpu} style={styles.clearBtn}>
            Isprazni korpu
          </button>
        )}
      </div>

      {korpa.length === 0 ? (
        <div >
          <p >Vaša korpa je prazna.</p>
          
        </div>
      ) : (
        <div style={styles.content}>
          <div style={styles.list}>
            {korpa.map((item) => (
              <div key={item.proizvodId} style={styles.card}>
                <div style={styles.infoGroup}>
                  <h3 style={styles.itemTitle}>{item.naziv}</h3>
                  <p style={styles.itemAuthor}>{item.autor}</p>
                  <p style={styles.itemPrice}>
                    Cena: {item.cena} RSD
                  </p>
                </div>

                <div style={styles.actionsGroup}>
                  <div style={styles.quantityControls}>
                    <button
                      onClick={() => izmeniKolicinu(item.proizvodId, item.kolicina - 1)}
                      style={styles.qtyBtn}
                    >
                      -
                    </button>
                    <span style={styles.qtyText}>{item.kolicina}</span>
                    <button
                      onClick={() => izmeniKolicinu(item.proizvodId, item.kolicina + 1)}
                      style={styles.qtyBtn}
                    >
                      +
                    </button>
                  </div>

                  <div style={styles.itemSubtotal}>
                    Ukupno: {item.cena * item.kolicina} RSD
                  </div>

                  <button
                    onClick={() => ukloniIzKorpe(item.proizvodId)}
                    style={styles.removeBtn}
                  >
                    Ukloni
                  </button>
                </div>
              </div>
            ))}
          </div>

          <div style={styles.summaryCard}>
            <h3 style={styles.summaryTitle}>Pregled narudžbine</h3>
            <div style={styles.summaryRow}>
              <span>Ukupno za uplatu:</span>
              <span style={styles.totalAmount}>{ukupanIznos} RSD</span>
            </div>
            <button
              onClick={napraviPorudzbinu}
              style={styles.checkoutBtn}
            >
              Naruči
            </button>
          </div>
        </div>
      )}
    </div>
  );
}

const styles = {
  container: {
    minHeight: "100vh",
    backgroundColor: "#0d1117",
    color: "#ffffff",
    paddingTop: "100px",
    paddingBottom: "60px",
    paddingLeft: "40px",
    paddingRight: "40px",
    fontFamily:
      '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    maxWidth: "900px",
    margin: "0 auto",
    boxSizing: "border-box",
  },
  backLink: {
    color: "#2ea043",
    textDecoration: "none",
    fontSize: "14px",
    fontWeight: "600",
    display: "inline-block",
    marginBottom: "20px",
  },
  headerRow: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: "24px",
  },
  title: {
    fontSize: "32px",
    fontWeight: "800",
    margin: 0,
  },
  clearBtn: {
    backgroundColor: "transparent",
    color: "#f85149",
    border: "1px solid #f85149",
    padding: "6px 12px",
    fontSize: "13px",
    cursor: "pointer",
  },
  emptyContainer: {
    backgroundColor: "#161b22",
    border: "1px solid #30363d",
    padding: "40px",
    textAlign: "center",
  },
  emptyText: {
    color: "#8b949e",
    fontSize: "16px",
    marginBottom: "20px",
  },
  shopBtn: {
    backgroundColor: "#238636",
    color: "#ffffff",
    border: "none",
    padding: "10px 20px",
    fontSize: "14px",
    fontWeight: "600",
    cursor: "pointer",
  },
  content: {
    display: "flex",
    flexDirection: "column",
    gap: "24px",
  },
  list: {
    display: "flex",
    flexDirection: "column",
    gap: "16px",
  },
  card: {
    backgroundColor: "#161b22",
    border: "1px solid rgba(255, 255, 255, 0.08)",
    padding: "20px",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    flexWrap: "wrap",
    gap: "16px",
  },
  infoGroup: {
    display: "flex",
    flexDirection: "column",
    gap: "4px",
  },
  itemTitle: {
    fontSize: "18px",
    fontWeight: "700",
    margin: 0,
    color: "#ffffff",
  },
  itemAuthor: {
    fontSize: "13px",
    color: "#2ea043",
    margin: 0,
    fontWeight: "600",
  },
  itemPrice: {
    fontSize: "14px",
    color: "#8b949e",
    margin: "4px 0 0 0",
  },
  actionsGroup: {
    display: "flex",
    alignItems: "center",
    gap: "20px",
    flexWrap: "wrap",
  },
  quantityControls: {
    display: "flex",
    alignItems: "center",
    backgroundColor: "#0d1117",
    border: "1px solid #30363d",
  },
  qtyBtn: {
    backgroundColor: "transparent",
    color: "#ffffff",
    border: "none",
    padding: "6px 12px",
    fontSize: "16px",
    cursor: "pointer",
  },
  qtyText: {
    padding: "0 8px",
    fontSize: "14px",
    fontWeight: "600",
  },
  itemSubtotal: {
    fontSize: "16px",
    fontWeight: "700",
    color: "#ffffff",
    minWidth: "120px",
    textAlign: "right",
  },
  removeBtn: {
    backgroundColor: "#21262d",
    color: "#f85149",
    border: "none",
    padding: "8px 12px",
    fontSize: "13px",
    cursor: "pointer",
  },
  summaryCard: {
    backgroundColor: "#161b22",
    border: "1px solid #30363d",
    padding: "20px",
    marginTop: "12px",
  },
  summaryTitle: {
    fontSize: "18px",
    fontWeight: "700",
    margin: "0 0 16px 0",
  },
  summaryRow: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "baseline",
    marginBottom: "20px",
    fontSize: "16px",
  },
  totalAmount: {
    fontSize: "24px",
    fontWeight: "800",
    color: "#2ea043",
  },
  checkoutBtn: {
    width: "100%",
    padding: "12px",
    backgroundColor: "#238636",
    color: "#ffffff",
    border: "none",
    fontSize: "15px",
    fontWeight: "600",
    cursor: "pointer",
  },
};

export default Korpa;