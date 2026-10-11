import React from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();
  const location = useLocation();
  const korisnik = JSON.parse(localStorage.getItem("korisnik") || "{}");
  const isUlogovan = !!korisnik.username;
  const isAdmin = korisnik.uloga === "ADMIN";

  const tamneRute = [
    "/",
    "/login",
    "/register",
    "/zaboravljena-lozinka",
    "/resetuj-lozinku",
    "/verifikuj",
    "/knjige",
    "/korpa",
    "/porudzbine",
    "/admin",
    "/recenzije",
  ];
  const jeTamnaPozadina = tamneRute.includes(location.pathname);

  const styles = {
    nav: {
      backgroundColor: jeTamnaPozadina ? "rgba(13, 17, 23, 0.85)" : "#ffffff",
      backdropFilter: "blur(12px)",
      WebkitBackdropFilter: "blur(12px)",
      borderBottom: jeTamnaPozadina
        ? "1px solid rgba(255, 255, 255, 0.08)"
        : "1px solid #e1e4e8",
      padding: "16px 40px",
      display: "flex",
      justifyContent: "space-between",
      alignItems: "center",
      position: "fixed", // Fiksiran na vrhu
      top: 0,
      left: 0,
      width: "100%",
      zIndex: 100,
      boxSizing: "border-box",
      fontFamily:
        '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
      transition: "all 0.3s ease",
    },
    logo: {
      fontSize: "20px",
      fontWeight: "800",
      color: jeTamnaPozadina ? "#ffffff" : "#0d1117",
      textDecoration: "none",
      letterSpacing: "0.5px",
      display: "flex",
      alignItems: "center",
      gap: "8px",
    },
    logoAccent: {
      color: "#2ea043", 
    },
    linksContainer: {
      display: "flex",
      gap: "24px",
      alignItems: "center",
    },
    link: {
      color: jeTamnaPozadina ? "#c9d1d9" : "#484f58",
      textDecoration: "none",
      fontSize: "14px",
      fontWeight: "500",
      transition: "color 0.2s ease",
    },
    userSection: {
      display: "flex",
      alignItems: "center",
      gap: "12px",
      borderLeft: jeTamnaPozadina
        ? "1px solid rgba(255, 255, 255, 0.15)"
        : "1px solid #d0d7de",
    },
    userBadge: {
      display: "flex",
      alignItems: "center",
      gap: "8px",
      fontSize: "13px",
      fontWeight: "600",
      color:  "#e6fffa" ,
      backgroundColor:  "rgba(25, 32, 27, 0.15)",
        
      border:  "1px solid rgba(152, 156, 153, 0.3)"
       ,
      padding: "4px 12px",
      whiteSpace: "nowrap",
    },
    userAvatar: {
      width: "22px",
      height: "22px",
      backgroundColor: "#8da091",
      color: "#ffffff",
      display: "flex",
      alignItems: "center",
      justifyContent: "center",
      fontSize: "11px",
      fontWeight: "700",
    },
    logoutBtn: {
      background: "none",
      border: "none",
      color: jeTamnaPozadina ? "#8b949e" : "#57606a",
      fontSize: "13px",
      fontWeight: "600",
      cursor: "pointer",
      padding: "4px 8px",
      transition: "all 0.2s ease",
    },
    authBtn: {
      padding: "6px 14px",
      fontSize: "13px",
      fontWeight: "600",
      textDecoration: "none",
    },
    registerBtn: {
      backgroundColor: "#238636",
      color: "#ffffff",
    },
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("korisnik");
    navigate("/");
    window.location.reload();
  };

  const inicijal = korisnik.ime ? korisnik.ime.charAt(0).toUpperCase() : "U";

  return (
    <nav style={styles.nav}>
      <Link to="/" style={styles.logo}>
        <span style={styles.logoAccent}>Bookathon</span>
      </Link>

      <div style={styles.linksContainer}>
        <Link to="/knjige" style={styles.link}>
          Proizvodi
        </Link>

        {!isAdmin && isUlogovan && (
          <>
            <Link to="/korpa" style={styles.link}>
              Korpa
            </Link>
            <Link to="/porudzbine" style={styles.link}>
              Porudžbine
            </Link>
          </>
        )}

        {isAdmin && (
          <Link to="/admin" style={styles.link}>
            Admin
          </Link>
        )}

        {!isUlogovan ? (
          <>
            <Link to="/login" style={styles.link}>
              Prijavi se
            </Link>
            <Link
              to="/register"
              style={{ ...styles.authBtn, ...styles.registerBtn }}
            >
              Registruj se
            </Link>
          </>
        ) : (
          <div style={styles.userSection}>
            <div style={styles.userBadge}>
             
              {korisnik.ime} {korisnik.prezime}
            </div>

            <button onClick={logout} style={styles.logoutBtn}>
              Odjavi se
            </button>
          </div>
        )}
      </div>
    </nav>
  );
}

export default Navbar;