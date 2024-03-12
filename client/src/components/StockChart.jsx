import axios from "axios";
import React, { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { Link, useParams } from "react-router-dom";
import "../styles/stockChart.css"

const StockDataOptions = {
   chart: {
     type: "candlestick",
     height: 350,
   },
   title: {
     text: "CandleStick Chart",
     align: "left",
   },
   xaxis: {
     type: "datetime",
   },
   yaxis: {
     tooltip: {
       enabled: true,
     },
   },
};

function ApexCandleStick() {
 const [isLoading, setIsLoading] = useState(true);
 const [series, setSeries] = useState([]); // Use state for series
 const {ticker} = useParams();
 const [duration,setDuration] = useState("1D");

 const setChartData = async (ticker, duration) => {
   try {
     const { data } = await axios.get(
       process.env.REACT_APP_API_KEY + "/company/stock/candle/" + ticker + "/" + duration
     );

     const formattedSeries = [];
     const size = data.Date.length;
     for (let i = 0; i < size; i++) {
       formattedSeries.push({
         x: new Date(data.Date[i]),
         y: [data.Open[i], data.High[i], data.Low[i], data.Close[i]],
       });
     }

     setSeries([{data:formattedSeries}]); // Update series state
     setIsLoading(false); // Data is loaded, set loading to false
   } catch (e) {
     console.error(e); // Handle errors appropriately
   }
 };
 useEffect(() => {
  setChartData(ticker,duration);
 }, [duration]);


 return (
   <div>
      <div>Last {duration} Data</div>
      {isLoading ? (
       <p>Loading...</p>
     ) : (
       <Chart
         type="candlestick"
         height={400}
         options={StockDataOptions}
         series={series}
       />
       )}
       <div id="StockDuration">
        <button type="submit" onClick={()=>{setDuration("1D");setIsLoading(true)}}>1D</button>
        <button type="submit" onClick={()=>{setDuration("3D");setIsLoading(true)}}>3D</button>
        <button type="submit" onClick={()=>{setDuration("1W");setIsLoading(true)}}>1W</button>
        <button type="submit" onClick={()=>{setDuration("1M");setIsLoading(true)}}>1M</button>
        <button type="submit" onClick={()=>{setDuration("3M");setIsLoading(true)}}>3M</button>
        <button type="submit" onClick={()=>{setDuration("1Y");setIsLoading(true)}}>1Y</button>
       </div>
   </div>
 );
}

export default ApexCandleStick;
