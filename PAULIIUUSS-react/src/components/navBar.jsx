import React, { Component } from "react";
import { Link } from "react-router-dom";

export default class navBar extends Component {
  render() {
    return (
      <div className="row">
        <div className="col-12">
          <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item">
                  <Link to="/" className="nav-link">
                    Namai
                  </Link>
                </li>
                <li className="nav-item">
                  <Link to="/admin" className="nav-link">
                    Admin Forma
                  </Link>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    );
  }
}
