import React, { useState, useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import { authApi } from "../services/api";

function VerifikacijaEmail() {
  const [searchParams] = useSearchParams();
  const token = searchParams.get("token");
  const [potvrdjen, setPotvrdjen] = useState(false);
  const [email, setEmail] = useState("");
  const [greska, setGreska] = useState("");
  const [podaci, setPodaci] = useState({
    username: "",
    password: "",
    ime: "",
    prezime: "",
    adresa: "",
  });
  const navigate = useNavigate();

  useEffect(() => {
    if (token) {
      authApi
        .verifikujToken(token)
        .then((response) => {
          setPotvrdjen(true);
          setEmail(response.data.email);
        })
        .catch((error) => {
          setGreska(
            error.response?.data?.error || "Nevažeći ili istekao verifikacioni link."
          );
        });
    } else {
      setGreska("Verifikacioni token nedostaje.");
    }
  }, [token]);

  const dovrsiRegistraciju = async (e) => {
    e.preventDefault();

    try {
      const response = await authApi.dovrsiRegistraciju({
        token,
        ...podaci,
      });

      alert(
        response.data?.poruka || "Registracija uspešno završena! Možete se prijaviti."
      );
      navigate("/login");
    } catch (error) {
      alert(error.response?.data?.error || "Greška pri dovršavanju registracije.");
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        {greska ? (
          <>
            <h2 style={{ ...styles.header, color: "#f85149" }}>Greška</h2>
            <p style={styles.subHeader}>{greska}</p>
          </>
        ) : !potvrdjen ? (
          <p style={styles.subHeader}>Proveravam verifikacioni link...</p>
        ) : (
          <>
            <h2 style={styles.header}>Email Potvrđen!</h2>
            <p style={styles.subHeader}>
              Potvrđen mejl: {email}
              <br />
              Unesite preostale podatke za nalog.
            </p>

            <form onSubmit={dovrsiRegistraciju} style={styles.form}>
              <input
                placeholder="username"
                type="text"
                value={podaci.username}
                onChange={(e) => setPodaci({ ...podaci, username: e.target.value })}
                style={styles.input}
                required
              />
              <input
                placeholder="Lozinka"
                type="password"
                value={podaci.password}
                onChange={(e) => setPodaci({ ...podaci, password: e.target.value })}
                style={styles.input}
                required
              />
              <input
                placeholder="Ime"
                type="text"
                value={podaci.ime}
                onChange={(e) => setPodaci({ ...podaci, ime: e.target.value })}
                style={styles.input}
                required
              />
              <input
                placeholder="Prezime"
                type="text"
                value={podaci.prezime}
                onChange={(e) => setPodaci({ ...podaci, prezime: e.target.value })}
                style={styles.input}
                required
              />
              <input
                placeholder="Adresa"
                type="text"
                value={podaci.adresa}
                onChange={(e) => setPodaci({ ...podaci, adresa: e.target.value })}
                style={styles.input}
                required
              />

              <button type="submit" style={styles.btn}>
                Dovrši registraciju
              </button>
            </form>
          </>
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
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    padding: "20px",
    fontFamily: '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    boxSizing: "border-box",
  },
  card: {
    backgroundColor: "#161b22",
    border: "1px solid rgba(255, 255, 255, 0.08)",
    padding: "40px",
    width: "100%",
    maxWidth: "420px",
    boxShadow: "0 8px 24px rgba(0, 0, 0, 0.4)",
  },
  header: {
    fontSize: "24px",
    fontWeight: "800",
    margin: "0 0 12px 0",
    color: "#ffffff",
    textAlign: "center",
  },
  subHeader: {
    fontSize: "14px",
    color: "#8b949e",
    margin: "0 0 24px 0",
    lineHeight: "1.5",
    textAlign: "center",
  },
  form: {
    display: "flex",
    flexDirection: "column",
    gap: "16px",
  },
  input: {
    width: "100%",
    padding: "12px 16px",
    fontSize: "14px",
    backgroundColor: "#0d1117",
    color: "#ffffff",
    border: "1px solid #30363d",
    outline: "none",
    boxSizing: "border-box",
  },
  btn: {
    width: "100%",
    padding: "12px",
    backgroundColor: "#238636",
    color: "#ffffff",
    border: "none",
    fontSize: "14px",
    fontWeight: "600",
    cursor: "pointer",
    marginTop: "8px",
  },
};

export default VerifikacijaEmail;