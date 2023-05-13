import React, { Component } from 'react'
import CarService from '../services/CarService';

class CreateCarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            plateNumber: '',
            color: '',
            emailId: ''
        }
        this.changePlateNumberHandler = this.changePlateNumberHandler.bind(this);
        this.changeColorHandler = this.changeColorHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.saveOrUpdateCar = this.saveOrUpdateCar.bind(this);
    }

    componentDidMount() {

        if (this.state.id === '_add') {
            return
        } else {
            CarService.getCarById(this.state.id).then((res) => {
                let car = res.data;
                this.setState({
                    plateNumber: car.firstName,
                    color: car.lastName,
                    emailId: car.emailId
                });
            });
        }
    }
    saveOrUpdateCar = (e) => {
        e.preventDefault();
        let car = { plateNumber: this.state.plateNumber, color: this.state.color, emailId: this.state.emailId };

        // step 5
        if (this.state.id === '_add') {
            CarService.createCar(car).then(res => {
                this.props.history.push('/cars');
            });
        } else {
            CarService.updateCar(car, this.state.id).then(res => {
                this.props.history.push('/cars');
            });
        }
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

    getTitle() {
        if (this.state.id === '_add') {
            return <h3 className="text-center">Add Car</h3>
        } else {
            return <h3 className="text-center">Update Car</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
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

                                    <button className="btn btn-success" onClick={this.saveOrUpdateCar}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default CreateCarComponent
