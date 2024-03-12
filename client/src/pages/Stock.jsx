import axios from 'axios';
import React, { useEffect } from 'react'
import StockChart from "../components/StockChart";


function StockPage() {
  return (
    
    <div className="container mt-3">
      {/* <h2 className="mb-3">React Apexcharts CandleStick Chart Example</h2> */}
      <StockChart/>
    </div>
  )
}

export default StockPage