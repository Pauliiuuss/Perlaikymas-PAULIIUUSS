import React, { Component } from "react";
import NavBar from "../components/navBar";
import Sventes from "../components/sventesContainer";

export default class home extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <NavBar />
          <Sventes />
        </div>
      </div>
    );
  }
}
