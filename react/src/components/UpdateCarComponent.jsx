import React, { Component } from 'react'
import CarService from '../services/CarService';


class UpdateCarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            plateNumber: '',
            color: '',
            emailId: ''
        }
        this.changeplateNumberHandler = this.changeplateNumberHandler.bind(this);
        this.changeColorHandler = this.changeColorHandler.bind(this);
        this.updateCar = this.updateCar.bind(this);
    }

    componentDidMount() {
        CarService.getCarById(this.state.id).then((res) => {
            let car = res.data;
            this.setState({
                plateNumber: car.plateNumber,
                color: car.color,
                emailId: car.emailId
            });
        });
    }

    updateCar = (e) => {
        e.preventDefault();
        let car = { plateNumber: this.state.plateNumber, color: this.state.color, emailId: this.state.emailId };

        CarService.updateCar(car, this.state.id).then(res => {
            this.props.history.push('/cars');
        });
    }

    changePlateNumberHandler = (event) => {
        this.setState({ plateNumber: event.target.value });
    }

    changeColorHandler = (event) => {
        this.setState({ color: event.target.value });
    }

    changeEmailHandler = (event) => {
        this.setState({ emailId: event.target.value });
    }

    cancel() {
        this.props.history.push('/cars');
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Update Car</h3>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label> Plate Number: </label>
                                        <input placeholder="Plate number" name="plateNumber" className="form-control"
                                            value={this.state.plateNumber} onChange={this.changePlateNumberHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Color: </label>
                                        <input placeholder="Color" name="color" className="form-control"
                                            value={this.state.color} onChange={this.changeColorHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label> Email: </label>
                                        <input placeholder="Email Address" name="emailId" className="form-control"
                                            value={this.state.emailId} onChange={this.changeEmailHandler} />
                                    </div>

                                    <button className="btn btn-success" onClick={this.updateCar}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div >
        )
    }
}

export default UpdateCarComponent
