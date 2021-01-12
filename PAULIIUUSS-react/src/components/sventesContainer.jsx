import React, { Component } from "react";
import Svente from "./sventesComponent";
import Axios from "axios";

export default class sveikinimuSarasas extends Component {
  constructor(props) {
    super();
    this.state = {
      sventes: [],
    };
  }

  componentDidMount() {
    Axios.get("http://localhost:8081/api/sventes/")
      .then((response) => {
        this.setState({ sventes: response.data });
      })
      .catch((err) => {
        console.log(err);
      });
  }

  render() {
    const { sventes } = this.state;
    if (sventes.length > 0) {
      return (
        <div className="container">
          <div className="row">
            {sventes.map((sv) => {
              return <Svente key={sv.id} product={sv} />;
            })}
          </div>
        </div>
      );
    } else {
      return <div>Loading...</div>;
    }
  }
}
