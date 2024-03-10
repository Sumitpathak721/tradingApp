import React from 'react'
import { useAuth } from '../context/auth'
import { Link, Navigate } from 'react-router-dom'
import { toast } from "react-toastify";

import axios from "axios"

function Register() {
  const [auth,setAuth] = useAuth()
  const handleSubmit = async(event) => {
    event.preventDefault();
    
    const jsonData = {
      name:event.target.name.value,
      email:event.target.email.value,
      password:event.target.password.value
    }
    const config = {
      headers: {
        'Content-Type': 'application/json'
      }
    };
    const response = await axios.post(process.env.REACT_APP_API_KEY+'/user/register', JSON.stringify(jsonData),config);
    if (response.status==201){
      toast.success(response.data);
    }else{
      toast.error(response.data);
    }
    
  }
  if(auth.user) return <Navigate to="/" />
  return (
    <div className="authContainer">
      <h2>Welcome to Our TradingApp! <span>😊</span></h2>
      <p>Please sign up to new account and start the adventure</p>
      <form className="auth-form" onSubmit={handleSubmit}>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Enter your name"/>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email"/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password"/>
        <button type="submit">Register</button>
      </form>
      <p>Already have account? <Link to={process.env.REACT_APP_URL+"/login"} className="create-account">Sign In to your account</Link></p>
    </div>
  )
}

export default Register