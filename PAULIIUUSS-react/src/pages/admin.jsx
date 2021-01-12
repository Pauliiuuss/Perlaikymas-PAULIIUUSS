import React, { Component } from "react";
import AdminFormContainer from "../components/adminFormContainer";
import NavBar from "../components/navBar";

export default class admin extends Component {
  render() {
    return (
      <div className="container">
        <div className="row">
          <NavBar />
          <AdminFormContainer />
        </div>
      </div>
    );
  }
}
