import * as React from 'react';
import "../styles/header.css"
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import AccountCircle from '@mui/icons-material/AccountCircle';
import MenuIcon from '@mui/icons-material/Menu';
import { Avatar, Input, TextField } from '@mui/material';


export default function Header() {
  return (
    <div className='header'>
        <IconButton className="icon">TradingApp</IconButton>
        <div className="searchBox">
            <input type='search' placeholder='Search for Company Name, Symbol, etc..'/>
        </div>
        <div className='avatar'>
        <Avatar
            size="large"
            color="inherit"
            style={{float:"right"}}
        >
            <AccountCircle />
        </Avatar>
        </div>
        
          
    </div>
  );
}
