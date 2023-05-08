import React, { Component } from 'react'
import CarService from '../services/CarService'

class ListEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            cars: []
        }
    }

    componentDidMount() {
        CarService.getCars().then((res) => {
            this.setState({ cars: res.data });
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Cars List</h2>

                <br></br>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> Brand </th>
                                <th> Color </th>
                                <th> Owner name </th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.cars.map(
                                    car =>
                                        <tr key={car.id}>
                                            <td> {car.brand} </td>
                                            <td> {car.color}</td>
                                            <td> {car.ownerName}</td>
                                            <td></td>
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

export default ListEmployeeComponent