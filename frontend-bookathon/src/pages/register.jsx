import React, { useState } from "react";
import { authApi } from "../services/api"; 

function Register() {
  const [email, setEmail] = useState("");
  const [poslato, setPoslato] = useState(false);

  const posaljiVerifikaciju = async (e) => {
    e.preventDefault();

    if (!email) {
      alert("Unesite email adresu!");
      return;
    }

    try {
      const response = await authApi.posaljiVerifikacioniMejl(email);
      alert(response.data?.poruka || "Verifikacioni link je poslat.");
      setPoslato(true);
    } catch (error) {
      alert(error.response?.data?.error || "Greška pri slanju verifikacije.");
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        <h2 style={styles.header}>Registracija</h2>

        {!poslato ? (
          <form onSubmit={posaljiVerifikaciju} style={styles.form}>
            <p style={styles.subHeader}>
              Unesite vašu email adresu. Poslaćemo vam verifikacioni link za nastavak registracije.
            </p>

            <input
              type="email"
              placeholder="Email adresa"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              style={styles.input}
              required
            />

            <button type="submit" style={styles.btn}>
              Pošalji verifikacioni link
            </button>
          </form>
        ) : (
          <p style={styles.subHeader}>
            Verifikacioni link je uspešno poslat na <strong>{email}</strong>. Proverite vaš inbox (i spam folder) i kliknite na link u poruci.
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
    maxWidth: "400px",
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
  },
};

export default Register;






