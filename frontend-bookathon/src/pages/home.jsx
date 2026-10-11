import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  const korisnik = JSON.parse(localStorage.getItem('korisnik') || '{}');
  const isUlogovan = !!korisnik.username;

  return (
    <div style={styles.container}>
      
      <section style={styles.heroSection}>
        <div style={styles.heroContent}>
          <span style={styles.badge}>Dobrodošli na Bookathon</span>
          <h1 style={styles.heroTitle}>
           <span style={styles.greenText}> Vaša omiljena online knjižara</span>
          </h1>
          <p style={styles.heroSubtitle}>
            Istražite bogatu kolekciju naslova, naručite omiljene knjige u par klikova i uživajte u brzanoj isporuci na vašu adresu.
          </p>
          <div style={styles.heroButtons}>
            
            
          </div>
        </div>
      </section>

  


    </div>
  );
};

const styles = {
  container: {
    minHeight: '100vh',
    width: '100vw',
    backgroundColor: '#0d1117',
    color: '#ffffff',
    fontFamily: '-apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif',
    paddingTop: '80px', // Prostor za fiksirani Navbar
    boxSizing: 'border-box',
    overflowX: 'hidden',
  },
  heroSection: {
    padding: '80px 20px',
    backgroundImage: `linear-gradient(180deg, rgba(13, 17, 23, 0.6) 0%, #0d1117 100%), url('/images/bazencic.jpg')`,
    backgroundSize: 'cover',
    backgroundPosition: 'center',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    textAlign: 'center',
    marginTop: '160px',
  },
  heroContent: {
    maxWidth: '750px',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  badge: {
    fontSize: '13px',
    fontWeight: '600',
    color: '#2ea043',
    backgroundColor: 'rgba(46, 160, 67, 0.15)',
    border: '1px solid rgba(46, 160, 67, 0.3)',
    padding: '6px 16px',
    marginBottom: '20px',
  },
  heroTitle: {
    fontSize: '48px',
    fontWeight: '800',
    lineHeight: '1.2',
    marginBottom: '20px',
    color: '#ffffff',
  },
  greenText: {
    color: '#2ea043',
  },
  heroSubtitle: {
    fontSize: '18px',
    color: '#8b949e',
    lineHeight: '1.6',
    marginBottom: '32px',
  },
  heroButtons: {
    display: 'flex',
    gap: '16px',
  },
  btn: {
    padding: '12px 24px',
    fontSize: '15px',
    fontWeight: '600',
    textDecoration: 'none',
    transition: 'all 0.2s ease',
  },
  btnPrimary: {
    backgroundColor: '#238636',
    color: '#ffffff',
    boxShadow: '0 4px 12px rgba(35, 134, 54, 0.25)',
  },
  btnSecondary: {
    backgroundColor: '#21262d',
    color: '#c9d1d9',
    border: '1px solid #30363d',
  },
  featuresSection: {
    maxWidth: '1100px',
    margin: '0 auto',
    padding: '60px 20px',
  },
  grid: {
    display: 'grid',
    gridTemplateColumns: 'repeat(auto-fit, minmax(280px, 1fr))',
    gap: '24px',
  },
  card: {
    backgroundColor: '#161b22',
    border: '1px solid rgba(255, 255, 255, 0.08)',
    padding: '32px 24px',
    textAlign: 'center',
  },
  iconContainer: {
    fontSize: '36px',
    marginBottom: '16px',
  },
  cardTitle: {
    fontSize: '20px',
    fontWeight: '700',
    marginBottom: '12px',
    color: '#ffffff',
  },
  cardText: {
    fontSize: '14px',
    color: '#8b949e',
    lineHeight: '1.5',
  },
  ctaSection: {
    maxWidth: '1100px',
    margin: '0 auto 80px',
    padding: '0 20px',
  },
  ctaCard: {
    backgroundColor: 'rgba(22, 27, 34, 0.7)',
    backdropFilter: 'blur(10px)',
    border: '1px solid rgba(46, 160, 67, 0.3)',
    padding: '48px',
    textAlign: 'center',
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
  },
  ctaTitle: {
    fontSize: '32px',
    fontWeight: '700',
    marginBottom: '12px',
  },
  ctaText: {
    fontSize: '16px',
    color: '#8b949e',
    marginBottom: '24px',
  },
};

export default Home;