import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Home from "../pages/home";

import NotFound from "../pages/notFound";

import Admin from "../pages/admin";

export default class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path="/">
            <Home />
          </Route>
          <Route path="/admin">
            <Admin />
          </Route>
          <Route>
            <NotFound />
          </Route>
        </Switch>
      </Router>
    );
  }
}
