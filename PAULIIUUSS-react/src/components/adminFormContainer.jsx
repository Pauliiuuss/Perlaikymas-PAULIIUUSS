import React, { Component } from "react";
import axios from "axios";

import AdminFormComponent from "./adminFormComponent";

export default class AdminFormContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      paveiksliukas: "",
      pilnasVardas: "",
      tekstas: "",
      audioIrasoUrl: "",
      id: "",
      sveikinimoVieta: "",
    };
  }

  componentDidMount() {
    if (this.props.match.params.id > 0) {
      axios
        .get(`localhost:8081/api/svente/${this.props.match.params.id}`)
        .then((response) =>
          this.setState({
            id: response.data.id || "",
            paveiksliukoUrl: response.data.paveiksliukoUrl || "",
            tekstas: response.data.tekstas || "",
            audioIrasoUrl: response.data.audioIrasoUrl || "",
            pilnasVardas: response.data.pilnasVardas || "",
            sveikinimoVieta: response.data.sveikinimoVieta || "",
          })
        )
        .catch((err) => console.log(err));
    }
  }

  handleSubmit = (e) => {
    e.preventDefault();

    if (this.state.id) {
      axios.put(
        `localhost:8081/api/sventes/prideti${this.props.match.params.id}`,
        {
          paveiksliukoUrl: this.state.paveiksliukoUrl || "",
          tekstas: this.state.tekstas || "",
          audioIrasoUrl: this.state.audioIrasoUrl || "",
          pilnasVardas: this.state.pilnasVardas || "",
          sveikinimoVieta: this.state.sveikinimoVieta || "",
        }
      );
    } else {
      axios.post(`localhost:8081/api/sventes/prideti`, {
        paveiksliukoUrl: this.state.paveiksliukoUrl || "",
        tekstas: this.state.tekstas || "",
        audioIrasoUrl: this.state.audioIrasoUrl || "",
        pilnasVardas: this.state.pilnasVardas || "",
        sveikinimoVieta: this.state.sveikinimoVieta || "",
      });

      this.setState({
        id: "",
        paveiksliukas: "",
        tekstas: "",
        audioUrl: "",
        vardas: "",
        pavarde: "",
        tipas: "",
      });
    }
  };

  handleChange = (e) => {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  };

  render() {
    return (
      <AdminFormComponent
        handleSubmit={this.handleSubmit}
        handleChange={this.handleChange}
        {...this.state}
      />
    );
  }
}
