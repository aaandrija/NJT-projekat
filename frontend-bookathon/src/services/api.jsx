
import axios from "axios";

const API_URL = "http://localhost:8080/api";

const api = axios.create({ baseURL: API_URL });

api.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export const authApi = {
  login: (username, password) => api.post("/auth/login", { username, password }),
  register: (userData) => api.post("/auth/register", userData),
  posaljiVerifikacioniMejl: (email) => api.post("/auth/posalji-verifikaciju", { email: email }),
  verifikujToken: (token) => api.get(`/auth/verifikuj/${token}`),
  dovrsiRegistraciju: (podaci) => api.post("/auth/dovrsi-registraciju", podaci),
};

export const knjigaApi={
 getAll:()=>api.get("/knjige"),
 getById: (id) => api.get(`/knjige/${id}`),
  save: (podaci) => api.post("/knjige", podaci),
  update: (id, podaci) => api.put(`/knjige/${id}`, podaci),
  delete: (id) => api.delete(`/knjige/${id}`),
};

export const proizvodApi = knjigaApi;

export const recenzijaApi = {
  getByKnjigaId: (knjigaId) => api.post("/recenzije/prikazi", { id: String(knjigaId) }),
  create: (novaRecenzijaObj)=> api.post("/recenzije/dodaj",novaRecenzijaObj),
};




export const porudzbinaApi = {
  getAll: () => api.get("/porudzbine"),
  create: (podaci) => api.post("/porudzbine", podaci),
  getById: (id) => api.get(`/porudzbine/${id}`),
  otkazi: (id) => api.put(`/porudzbine/${id}/otkazi`),
 getPoKorisniku: (korisnikID) => api.get(`/porudzbine/korisnik/${korisnikID}`),
};

export const otpremnicaApi = {
  getAll: () => api.get("/otpremnice"),
  generisi: (podaci) => api.post("/otpremnice/generisi", podaci),
  storniraj: (id) => api.put(`/otpremnice/${id}/storniraj`),
};

export const izdavackaKucaApi={
  getAll: ()=>api.get("izdavacke-kuce"),
};