import React, { Component } from 'react'
import CarService from '../services/CarService'

class ListCarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            cars: []
        }
        this.addCar = this.addCar.bind(this);
        this.editCar = this.editCar.bind(this);
        this.deleteCar = this.deleteCar.bind(this);
    }

    deleteCar(id) {
        CarService.deleteCar(id).then(res => {
            this.setState({ cars: this.state.cars.filter(car => car.id !== id) });
        });
    }

    viewCar(id) {
        this.props.history.push(`/view-car/${id}`);
    }

    editCar(id) {
        this.props.history.push(`/add-car/${id}`);
    }

    componentDidMount() {
        CarService.getCars().then((res) => {
            this.setState({ cars: res.data });
        });
    }

    addCar() {
        this.props.history.push('/add-car/_add');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Cars List</h2>
                <div className="row">
                    <button className="btn btn-primary" onClick={this.addCar}> Add Car</button>
                </div>
                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> Car Plate Number</th>
                                <th> Car color</th>
                                <th> Owner email</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.cars.map(
                                    car =>
                                        <tr key={car.id}>
                                            <td> {car.plateNumber} </td>
                                            <td> {car.color}</td>
                                            <td> {car.emailId}</td>
                                            <td>
                                                <button onClick={() => this.editCar(car.id)} className="btn btn-info">Update </button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.deleteCar(car.id)} className="btn btn-danger">Delete </button>
                                                <button style={{ marginLeft: "10px" }} onClick={() => this.viewCar(car.id)} className="btn btn-info">View </button>
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>

                </div>

            </div>
        )
    }
}

export default ListCarComponent
