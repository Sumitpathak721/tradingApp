import React, { useEffect, useState } from 'react'
import "../styles/Home.css"
import { useParams } from 'react-router-dom';
import CompanyCard from '../components/CompanyCard'

// Material UI :
import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';



import axios from 'axios'

function HomePage() {
  const {pageNumber} = useParams()
  const [companies,setCompanies] = useState([]);
  useEffect(() => {
    const loadData = async () => {
        if(pageNumber==undefined){
          const {data} = await axios.get(process.env.REACT_APP_API_KEY + '/company/all/0');
          setCompanies(data);
        }else{
          const {data} = await axios.get(process.env.REACT_APP_API_KEY + '/company/all/'+pageNumber);
          setCompanies(data);
        }
        
    };
    loadData(); // Call loadData only once on component mount
  }, []);

  return (
    <div className="home">
      {companies ? <>
        {companies.map(company=>(
          <CompanyCard company={company}/>
        ))}
      </>:
      <Box >
        <CircularProgress />
      </Box>
      }
      <div className="homePageNav">
        <a href="/0">0</a>
        <a href="/1">1</a>
        <a href="/2">2</a>
        <a href="/3">3</a>
        <a href="/4">4</a>
        <a href="/5">5</a>
        <a href="/6">6</a>
        <a href="/7">7</a>
        <a href="/8">8</a>
        <a href="/9">9</a>
        <a href="/10">10</a>
        <a href="/11">11</a>
        <a href="/12">12</a>
        <a href="/13">13</a>
        <a href="/14">14</a>
        <a href="/15">15</a>
        <a href="/16">16</a>
        <a href="/17">17</a>
      </div>
    </div>
  )
}

export default HomePage