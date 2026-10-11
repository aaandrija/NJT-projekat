import React, { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { authApi } from "../services/api";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();


const styles = {
  container: {
    display: "flex",
    minHeight: "100vh",
    width: "100vw", // Osigurava punu širinu
    fontFamily:
      '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    backgroundColor: "#0d1117", // Tamna pozadina u SaaS stilu
    margin: 0,
    overflow: "hidden",
  },

  heroSection: {
    flex: "1",
    backgroundImage: `linear-gradient(135deg, rgba(8, 60, 35, 0.9) 0%, rgba(13, 110, 80, 0.7) 100%), url('/images/bazencic.jpg')`,
    backgroundSize: "cover",
    backgroundPosition: "center",
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    padding: "60px",
    color: "#ffffff",
  },
  heroTitle: {
    fontSize: "42px",
    fontWeight: "800",
    marginBottom: "16px",
    lineHeight: "1.2",
    color: "#e6fffa", 
  },
  heroSubtitle: {
    fontSize: "18px",
    color: "#a0aec0",
    maxWidth: "480px",
    lineHeight: "1.6",
  },

  formSection: {
    width: "480px",
    backgroundColor: "#161b22", 
    display: "flex",
    flexDirection: "column",
    justifyContent: "center",
    padding: "60px 48px",
    boxSizing: "border-box",
    borderLeft: "1px solid rgba(255, 255, 255, 0.08)",
  },
  title: {
    fontSize: "28px",
    fontWeight: "700",
    marginBottom: "8px",
    color: "#ffffff",
  },
  subtitle: {
    fontSize: "14px",
    color: "#8b949e",
    marginBottom: "32px",
  },

  // Input polja (grupa)
  inputGroup: {
    marginBottom: "20px",
  },
  label: {
    display: "block",
    fontSize: "13px",
    fontWeight: "600",
    color: "#c9d1d9",
    marginBottom: "8px",
  },
  input: {
    width: "100%",
    padding: "14px 16px",
    border: "1px solid #30363d",
    backgroundColor: "#0d1117",
    color: "#ffffff",
    fontSize: "15px",
    outline: "none",
    boxSizing: "border-box",
    transition: "border-color 0.2s ease",
  },
  inputFocus: {
    borderColor: "#2ea043", 
  },

  btn: {
    width: "100%",
    padding: "14px",
    marginTop: "12px",
    backgroundColor: "#238636", // Upečatljiva zelena
    color: "#ffffff",
    border: "none",
    fontSize: "15px",
    fontWeight: "600",
    cursor: "pointer",
    boxShadow: "0 4px 12px rgba(35, 134, 54, 0.2)",
    transition: "background-color 0.2s ease, transform 0.1s ease",
  },
  

  footerText: {
    marginTop: "24px",
    textAlign: "center",
    fontSize: "14px",
    color: "#8b949e",
  },
  link: {
    color: "#2ea043", 
    textDecoration: "none",
    fontWeight: "600",
  },
};


 
  const login = async () => {
    try {
      const response = await authApi.login(username, password);
      localStorage.setItem("token", response.data.token);
      localStorage.setItem("korisnik", JSON.stringify(response.data));
      alert("Uspešno ste se prijavili!");
      navigate("/");
      window.location.reload();
    } catch (error) {
      alert(error.response?.data?.error || "Greška pri prijavi.");
    }
  };

  return (
      <div style={styles.container}>
  <div style={styles.heroSection}>
    <h1 style={styles.heroTitle}>Dobrodošli nazad</h1>
    
  </div>

  <div style={styles.formSection}>
    <h2 style={styles.title}>Prijava</h2>
    <p style={styles.subtitle}>Unesite vaše podatke</p>

    <div style={styles.inputGroup}>
      <label style={styles.label}>Korisničko ime</label>
      <input
        value={username}
        onChange={(e) => setUsername(e.target.value)}
        style={styles.input}
      />
    </div>

    <div style={styles.inputGroup}>
      <label style={styles.label}>Lozinka</label>
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        style={styles.input}
      />
    </div>

    <button onClick={login} style={styles.btn}>
      Prijavi se
    </button>

    <p style={styles.footerText}>
      
      <Link to="/register" style={styles.link}>
        Registrujte se
      </Link>
    </p>

    {/* Ako želiš da vratiš link za zaboravljenu lozinku:
    <p style={{ ...styles.footerText, marginTop: "8px" }}>
      <Link to="/zaboravljena-lozinka" style={styles.link}>
        Zaboravili ste lozinku?
      </Link>
    </p> 
    */}
  </div>
</div>
    // <div style={styles.container}>
    //   <div style={styles.box}>
    //     <h2 style={styles.title}>Prijava</h2>
    //     <input
    //       placeholder="Korisničko ime"
    //       value={username}
    //       onChange={(e) => setUsername(e.target.value)}
    //       style={styles.input}
    //     />
    //     <input
    //       placeholder="Lozinka"
    //       type="password"
    //       value={password}
    //       onChange={(e) => setPassword(e.target.value)}
    //       style={styles.input}
    //     />
    //     <button onClick={login} style={styles.btn}>
    //       Prijavi se
    //     </button>
    //     <p
    //       style={{
    //         textAlign: "center",
    //         marginTop: "16px",
    //         fontSize: "13px",
    //         color: "#e6f4fa",
    //       }}
    //     >
    //       Nemate nalog?{" "}
    //       <Link to="/register" style={styles.link}>
    //         Registrujte se
    //       </Link>
    //     </p>
    //     {/* <p style={{ textAlign: "center", marginTop: "8px", fontSize: "13px" }}>
    //       <Link to="/zaboravljena-lozinka" style={styles.link}>
    //         Zaboravili ste lozinku?
    //       </Link>
    //     </p> */}
    //   </div>
    // </div>
  );
}

export default Login;
