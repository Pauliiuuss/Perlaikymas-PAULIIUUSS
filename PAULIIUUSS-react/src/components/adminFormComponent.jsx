import React from "react";

const ProductAdministrationFormComponent = ({
  handleChange,
  handleSubmit,
  ...otherProps
}) => {
  const {
    valstybe,
    metai,
    pavadinimas,
    aprasymas,
    paveiksliukoUrl,
    veliava,
  } = otherProps;
  return (
    <div>
      <form className="container my-5" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="valstybe">Valstybes pavadinimas</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="valstybe"
            name="valstybe"
            value={valstybe}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="metai">Sventes metai</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="metai"
            name="metai"
            value={metai}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="pavadinimas">Sventes pavadinimas</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            id="pavadinimas"
            name="pavadinimas"
            value={pavadinimas}
          ></textarea>
        </div>
        <div className="form-group">
          <label htmlFor="aprasymas">Sventes aprasymas</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            id="aprasymas"
            name="aprasymas"
            value={aprasymas}
          ></textarea>
        </div>
        <div className="form-group">
          <label htmlFor="img">Paveiksliuko Url</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            id="img"
            name="img"
            value={paveiksliukoUrl}
          ></textarea>
        </div>
        <button type="submit" className="btn btn-primary">
          Save
        </button>
      </form>
    </div>
  );
};

export default ProductAdministrationFormComponent;
