import React from 'react'
import {Link} from "react-router-dom";
import "../styles/CompanyCard.css"

export default function CompanyCard(props) {
  return (
    <div className="companycard">
        <img src={props.company.logoLink} className="cc-img"/>
        <div className="cc-div">
            {props.company.companyName}
        </div>
        <Link to={"/stocks/"+props.company.symbol}>More Detail</Link>
    </div>
  )
}