import { BrowserRouter,Routes, Route, Router } from "react-router-dom";
import Home from "./pages/Home.jsx";
import About from "./pages/About.jsx";
import Transection from "./pages/Transection.jsx"
import Stock from "./pages/Stock.jsx"
import Register from "./pages/Register.jsx"
import Login from "./pages/Login.jsx";
import Layout from "./components/Layout.jsx";
import { AuthProvider } from "./context/auth.js";
import "bootstrap/dist/css/bootstrap.min.css";
import PrivateRoute from "./PrivateComponent/PrivateRoute.jsx";

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/" element={<PrivateRoute />}>
            <Route element={<Layout/>}>
              <Route index element={<Home />} />
              <Route path=":pageNumber" element={<Home />} />
              <Route path="transection" element={<Transection />} />
              <Route path="stocks/:ticker" element={<Stock />} />
            </Route>
          </Route>
          <Route path="/about" element={<About />} />
        </Routes>
      </AuthProvider>
    </BrowserRouter>
  );
}


export default App;
