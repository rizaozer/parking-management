import React, { Component } from 'react'
import CarService from '../services/CarService'

class ViewCarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            car: {}
        }
    }

    componentDidMount() {
        CarService.getCarById(this.state.id).then(res => {
            this.setState({ car: res.data });
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className="card col-md-6 offset-md-3">
                    <h3 className="text-center"> View Car Details</h3>
                    <div className="card-body">
                        <div className="row">
                            <label> Car Plate Number: </label>
                            <div> {this.state.car.plateNumber}</div>
                        </div>
                        <div className="row">
                            <label> Car Color: </label>
                            <div> {this.state.car.color}</div>
                        </div>
                        <div className="row">
                            <label> Owner Email: </label>
                            <div> {this.state.car.emailId}</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewCarComponent
