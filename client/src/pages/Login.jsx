import React, { useEffect, useState } from 'react'; // Import useState for controlled inputs 
import { useAuth } from '../context/auth.js'; // Import the useAuth hook
import { Link, Navigate,useNavigate } from 'react-router-dom';
import { toast } from "react-toastify";

import axios from "axios"
import "../styles/auth.css"

function Login() {
  const [auth, setAuth] = useAuth();
  const navigate = useNavigate();
  const handleSubmit = async(event) => {
    event.preventDefault();
    
    const jsonData = {
      email:event.target.email.value,
      password:event.target.password.value
    }
    const config = {
      headers: {
        'Content-Type': 'application/json'
      }
    };
    const {data} = await axios.post(process.env.REACT_APP_API_KEY+'/user/login', JSON.stringify(jsonData),config);

    if (data.status){
      console.log(data);
      let newData  = {
        user:{
          id:data.id,
          name:data.username
        },
        token:data.token
      }
      setAuth(newData);
      toast.success(data.message);
      navigate("/")
    }else{
      toast.error(data.message+"!!");
    }
    
  }
  useEffect(() => {
    if (auth.user) {
      navigate("/");
    }
  }, [auth.user, navigate]);

  if(auth.user) return <Navigate to="/" replace/>
  return (    
    
    <div className="authContainer">
      <h2>Welcome to Our TradingApp! <span>😊</span></h2>
      <p>Please sign in to your account and start the adventure</p>
      <form className="auth-form" onSubmit={handleSubmit}>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email"/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password"/>
        <button type="submit">Log in</button>
      </form>
      <p>New on our platform? <Link to={process.env.REACT_APP_URL+"/register"} className="create-account">Create an account</Link></p>
    </div>
    
  );
}

export default Login;