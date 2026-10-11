import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { recenzijaApi } from "../services/api";

function Recenzije() {
  const [recenzije, setRecenzije] = useState([]);
  const [loading, setLoading] = useState(true);

  const [novaOcena, setNovaOcena] = useState(5);
  const [noviKomentar, setNoviKomentar] = useState("");
  const [submitting, setSubmitting] = useState(false);

  const knjigaId = localStorage.getItem("selectedKnjigaId");
  
  const sacuvaniKorisnik = localStorage.getItem("korisnik");
  const korisnikObj = sacuvaniKorisnik ? JSON.parse(sacuvaniKorisnik) : null;
  const userId = korisnikObj?.korisnikID || korisnikObj?.userID || korisnikObj?.id;

  useEffect(() => {
    if (knjigaId) {
      ucitajRecenzije(knjigaId);
    } else {
      setLoading(false);
    }
  }, []);

  const ucitajRecenzije = async (id) => {
    try {
      const response = await recenzijaApi.getByKnjigaId(id);
      setRecenzije(response.data);
    } catch (error) {
      console.error("Greška pri učitavanju recenzija:", error);
    } finally {
      setLoading(false);
    }
  };

  const handleDodajRecenziju = async (e) => {
    e.preventDefault();

    

    setSubmitting(true);

    try {
      const novaRecenzijaObj = {
        knjigaID: Number(knjigaId),
        userID: Number(userId),
        ocena: Number(novaOcena),
        poruka: noviKomentar,
      };

     
       const response= await recenzijaApi.create(novaRecenzijaObj);
      

      alert(response.data.poruka);

      setNoviKomentar("");
      setNovaOcena(5);
      ucitajRecenzije(knjigaId);
    } catch (error) {
      alert(error.response.data.error);
    } finally {
      setSubmitting(false);
    }
  };

  // if (loading) return <div style={styles.container}>Učitavanje...</div>;

  return (
    <div style={styles.container}>
      

      <h2 style={styles.title}>Recenzije za knjigu</h2>

      {recenzije.length === 0 ? (
        <p style={styles.empty}>Nema recenzija za izabranu knjigu.</p>
      ) : (
        <div style={styles.list}>
          {recenzije.map((r) => (
            <div key={r.recenzijaID} style={styles.card}>
              <div style={styles.headerRow}>
                <span style={styles.korisnik}>{r.korsinik || r.korisnik || "Anonimno"}</span>
                <span style={styles.ocena}>Ocena: {r.ocena}</span>
              </div>
              <p style={styles.komentar}>{r.poruka || r.tekst}</p>
            </div>
          ))}
        </div>
      )}

      <div style={styles.formContainer}>
        <h3 style={styles.formTitle}>Dodaj svoju recenziju</h3>

        {userId ? (
          <form onSubmit={handleDodajRecenziju} style={styles.form}>
            <div style={styles.fieldGroup}>
              <label style={styles.label}>Ocena :</label>
              <input
                value={novaOcena}
                onChange={(e) => setNovaOcena(e.target.value)}
                style={styles.inputNumber}
              />
            </div>

            <div style={styles.fieldGroup}>
              <label style={styles.label}>Komentar:</label>
              <textarea
                rows="3"
                value={noviKomentar}
                onChange={(e) => setNoviKomentar(e.target.value)}
                style={styles.textarea}
              />
            </div>

            <button type="submit" disabled={submitting} style={styles.button}>
              {submitting ? "Slanje..." : "Ostavi recenziju"}
            </button>
          </form>
        ) : (
          <p style={styles.loginWarning}>
            Morate biti prijavljeni da biste ostavili recenziju.
          </p>
        )}
      </div>
    </div>
  );
}

const styles = {
  container: {
    minHeight: "100vh",
    backgroundColor: "#0d1117",
    color: "#ffffff",
    paddingTop: "60px",
    paddingBottom: "60px",
    paddingLeft: "40px",
    paddingRight: "40px",
    fontFamily: '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    maxWidth: "800px",
    margin: "0 auto",
  },
  backLink: {
    color: "#2ea043",
    textDecoration: "none",
    fontSize: "14px",
    fontWeight: "600",
    display: "inline-block",
    marginBottom: "20px",
  },
  title: {
    fontSize: "28px",
    fontWeight: "800",
    marginBottom: "24px",
  },
  empty: {
    color: "#8b949e",
    fontSize: "16px",
  },
  list: {
    display: "flex",
    flexDirection: "column",
    gap: "16px",
    marginBottom: "40px",
  },
  card: {
    backgroundColor: "#161b22",
    border: "1px solid #30363d",
    padding: "16px",
  },
  headerRow: {
    display: "flex",
    justifyContent: "space-between",
    marginBottom: "8px",
  },
  korisnik: {
    fontWeight: "700",
    fontSize: "15px",
    color: "#ffffff",
  },
  ocena: {
    color: "#2ea043",
    fontWeight: "700",
  },
  komentar: {
    color: "#8b949e",
    fontSize: "14px",
    margin: 0,
    lineHeight: "1.4",
  },
  formContainer: {
    marginTop: "40px",
    backgroundColor: "#161b22",
    border: "1px solid #30363d",
    padding: "20px",
  },
  formTitle: {
    fontSize: "18px",
    fontWeight: "700",
    marginBottom: "16px",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "14px",
  },
  fieldGroup: {
    display: "flex",
    flexDirection: "column",
    gap: "6px",
  },
  label: {
    fontSize: "14px",
    color: "#8b949e",
  },
  inputNumber: {
    backgroundColor: "#0d1117",
    color: "#ffffff",
    border: "1px solid #30363d",
    padding: "8px 12px",
    fontSize: "14px",
    width: "80px",
  },
  textarea: {
    backgroundColor: "#0d1117",
    color: "#ffffff",
    border: "1px solid #30363d",
    padding: "10px",
    fontSize: "14px",
    resize: "vertical",
  },
  button: {
    backgroundColor: "#2ea043",
    color: "#ffffff",
    border: "none",
    padding: "10px 16px",
    fontWeight: "600",
    cursor: "pointer",
    alignSelf: "flex-start",
  },
  loginWarning: {
    color: "#8b949e",
    fontSize: "14px",
  },
};

export default Recenzije;