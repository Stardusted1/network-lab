var greeting = angular.module('greeting', [])
    .controller('greetingController', function ($http, $compile, $scope) {

        $scope.updatePersons = function () {
            let personsList = angular.element(document.querySelector("#persons"))
            //#region person add
            $http.get("/api/")
                .success(function (data) {
                    persons = data
                    let elements = []
                    let addbutton = angular.element(document.querySelector("#add-person-col"))
                    addbutton.remove();
                    let text = personsList.children()[0];
                    personsList.children().detach();
                    personsList.append(text)
                    for (let person of data) {
                        /*
                        <div class="col">
            <div class="border rounded content">
                <h1 class="text-center center-content">FirstName</h1>
                <h4 class="text-center center-content">Last name</h4>
                <h3 class="text-center center-content">Age</h3>
                <h2 class="text-center center-content">Height</h2>
                <h3 class="text-center center-content">Weight</h3>
                <h5 class="text-center center-content">id</h5>
                <div class="btn-group d-xl-flex justify-content-xl-center" role="group"
                     style="display: block;padding-top: 15px;margin: auto;">
                    <button class="btn btn-warning" type="button"><i class="fa fa-pencil"></i></button>
                    <button class="btn btn-danger" type="button"><i class="fa fa-trash"></i></button>
                </div>
            </div>
        </div>
                         */

                        let col = document.createElement("div");
                        col.className = "col"

                        let div = document.createElement("div")
                        div.className = "border rounded content"
                        col.append(div)
                        //#region textblocks
                        let textstyle = "text-center center-content"

                        let h1 = document.createElement('h1')
                        h1.className = textstyle
                        h1.innerText = person.firstName;
                        div.append(h1);

                        let h4 = document.createElement("h4")
                        h4.className = textstyle
                        h4.innerText = person.lastName;
                        div.append(h4)

                        let h3 = document.createElement('h3')
                        h3.className = textstyle
                        h3.innerText = person.age;
                        div.append(h3)

                        let h2 = document.createElement('h2')
                        h2.className = textstyle
                        h2.innerText = person.height
                        div.append(h2)

                        let h3_1 = document.createElement("h3")
                        h3_1.className = textstyle
                        h3_1.innerText = person.weight;
                        div.append(h3_1)

                        let h5 = document.createElement('h5')
                        h5.className = textstyle
                        h5.innerText = person.id
                        div.append(h5);
                        //#endregion textblocks

                        //#region buttons
                        let btnGr = document.createElement("div")
                        btnGr.className = "btn-group d-flex justify-content-center"
                        btnGr.setAttribute('role', 'group')
                        btnGr.setAttribute('style', 'display: block;padding-top: 15px;margin: auto;')
                        div.append(btnGr)

                        let changeButton = document.createElement('button')
                        changeButton.className = "btn btn-warning"
                        changeButton.setAttribute('type', 'button')
                        changeButton.setAttribute('ng-controller', 'greetingController')
                        changeButton.setAttribute('ng-click', 'changePerson(' + person.id + ')')
                        btnGr.append(changeButton)

                        let chIcon = document.createElement('i')
                        chIcon.className = 'fa fa-pencil'
                        changeButton.append(chIcon)

                        let delButton = document.createElement('button')
                        delButton.className = 'btn btn-danger'
                        delButton.setAttribute('type', 'button')
                        delButton.setAttribute('ng-controller', 'greetingController')
                        delButton.setAttribute('ng-click', 'deletePerson(' + person.id + ')')
                        btnGr.append(delButton)

                        let delIcon = document.createElement('i')
                        delIcon.className = 'fa fa-trash'
                        delButton.append(delIcon)
                        //#endregion buttons

                        col = angular.element(col)
                        $compile(col)($scope);
                        personsList.append(col)
                    }
                    personsList.append(addbutton)
                    console.log(data)
                }).error(function (data) {
                alert(data)
            })
            //#endregion
        }

        $scope.updateCars = function () {
            let carsList = angular.element(document.querySelector("#cars"))
            //#region person add
            $http.get("/api/cars")
                .success(function (data) {
                    cars = data
                    let elements = []
                    let addbutton = angular.element(document.querySelector("#add-car-col"))
                    addbutton.remove();
                    let text = carsList.children()[0];
                    carsList.children().detach();
                    carsList.append(text)
                    for (let car of data) {
                        /*
            <div class="col">
                <div class="content">
                    <h1 class="text-center center-content">Model</h1>
                    <h4 class="text-center center-content">EngineValue</h4>
                    <h4 class="text-center center-content">id</h4>
                    <div class="btn-group d-xl-flex justify-content-xl-center" role="group"
                         style="display: block;padding-top: 15px;margin: auto;">
                        <button class="btn btn-warning" type="button"><i class="fa fa-pencil"></i></button>
                        <button class="btn btn-danger" type="button"><i class="fa fa-trash"></i></button>
                    </div>
                </div>
            </div>
                         */

                        let col = document.createElement("div");
                        col.className = "col"

                        let div = document.createElement("div")
                        div.className = "border rounded content"
                        col.append(div)
                        //#region textblocks
                        let textstyle = "text-center center-content"

                        let h1 = document.createElement('h1')
                        h1.className = textstyle
                        h1.innerText = car.model;
                        div.append(h1);

                        let h4 = document.createElement("h4")
                        h4.className = textstyle
                        h4.innerText = car.engineVolume;
                        div.append(h4)

                        let h3 = document.createElement('h3')
                        h3.className = textstyle
                        h3.innerText = car.id;
                        div.append(h3)
                        //#endregion textblocks

                        //#region buttons
                        let btnGr = document.createElement("div")
                        btnGr.className = "btn-group d-flex justify-content-center"
                        btnGr.setAttribute('role', 'group')
                        btnGr.setAttribute('style', 'display: block;padding-top: 15px;margin: auto;')
                        div.append(btnGr)

                        let changeButton = document.createElement('button')
                        changeButton.className = "btn btn-warning"
                        changeButton.setAttribute('type', 'button')
                        changeButton.setAttribute('ng-controller', 'greetingController')
                        changeButton.setAttribute('ng-click', 'changeCar(' + car.id + ')')
                        btnGr.append(changeButton)

                        let chIcon = document.createElement('i')
                        chIcon.className = 'fa fa-pencil'
                        changeButton.append(chIcon)

                        let delButton = document.createElement('button')
                        delButton.className = 'btn btn-danger'
                        delButton.setAttribute('type', 'button')
                        delButton.setAttribute('ng-controller', 'greetingController')
                        delButton.setAttribute('ng-click', 'deleteCar(' + car.id + ')')
                        btnGr.append(delButton)

                        let delIcon = document.createElement('i')
                        delIcon.className = 'fa fa-trash'
                        delButton.append(delIcon)
                        //#endregion buttons

                        col = angular.element(col)
                        $compile(col)($scope);
                        carsList.append(col)
                    }
                    carsList.append(addbutton)
                    console.log(data)
                }).error(function (data) {
                createAlert(data, "danger")
            })
            //#endregion
        }

        $scope.addPerson = function () {
            let firstName = document.getElementById("add-person-fname").value;

            let lastName = document.getElementById("add-person-lname").value;
            let age = document.getElementById("add-person-age").value;
            let weight = document.getElementById("add-person-weight").value;
            let height = document.getElementById("add-person-height").value;
            let ownerships = document.getElementById("add-person-ownership").value;
            if (!currentPerson) {
                $http.put("/api/", {firstName, lastName, age, height, weight}
                ).success(
                    function (data) {
                        createAlert("person added", "success")
                    }
                ).error(function (data) {
                    createAlert("person not added" + data, "danger")
                })
            } else {
                let id = currentPerson.id;
                $http.patch('/api/' + currentPerson.id, {id, firstName, lastName, age, height, weight}
                ).success(function (data) {
                    createAlert("person updated", "info")
                }).error(function (data) {
                    createAlert("person not changed", "danger")
                })


                if (ownerships !== "") {
                    $http.post('/api/ownerships/fromuser/' + currentPerson.id, ownerships)
                        .success(function (data) {
                            createAlert("person updated ownerships", "info")
                        }).error(function (data) {
                        createAlert("person ownerships not changed " + data, "danger")
                    })
                }
            }

            currentPerson = null;
            $scope.updatePersons()
            //$compile(div)($scope);
        }

        $scope.addCar = function () {
            let model = document.getElementById('add-car-model').value;
            let engineVolume = document.getElementById("add-car-evalue").value;
            let ownerships = document.getElementById("add-car-ownership").value;
            if (!currentCar) {
                $http.put("/api/cars", {model, engineVolume}
                ).success(function () {
                    alert("added car")
                }).error(function () {
                    alert("not added")
                })
            } else {
                let id = currentCar.id;
                $http.patch('/api/' + currentCar.id + '/cars', {id, model, engineVolume}
                ).success(function (data) {
                    createAlert("car updated", "info")
                }).error(function (data) {
                    createAlert("car not changed", "danger")
                })
                if (ownerships !== "") {
                    $http.post('/api/ownerships/fromcar/' + currentCar.id, ownerships)
                        .success(function (data) {
                            createAlert("car updated ownerships", "info")
                        }).error(function (data) {
                        createAlert("car ownerships not changed " + data, "danger")
                    })
                }
            }
            currentCar = null;
            $scope.updateCars();
        }

        $scope.deletePerson = function (id) {
            for (let person of persons) {
                if (person.id === id) {
                    if (confirm("really delete " + person.id + "?"))
                        $http.delete('/api/' + person.id
                        ).success(function (data) {
                            createAlert("deleted person " + person.id, "info")
                        }).error(function (data) {
                            createAlert(data, "danger")
                        })
                }
            }
            $scope.updatePersons()
        }

        $scope.deleteCar = function (id) {
            for (let car of cars) {
                if (car.id === id) {
                    if (confirm("really delete " + car.id + "?"))
                        $http.delete('/api/' + car.id + "/cars"
                        ).success(function (data) {
                            createAlert("deleted car " + car.id, "info")
                        }).error(function (data) {
                            createAlert(data, "danger")
                        })
                }
            }
            $scope.updateCars()
        }

        $scope.changePerson = function (id) {
            for (let person of persons) {
                if (person.id === id) {
                    currentPerson = person;
                    $http.get('/api/ownerships/person/' + person.id).success(function (data) {
                        let ownerships = ''
                        for (let ownership of data) {
                            ownerships += ownership.property.id + " ,"
                        }
                        $('#add-person-ownership').val(ownerships);
                    }).error(function (data) {
                        createAlert("unable to load properties " + data, 'danger')
                    })
                    $('#add-person-modal').modal('show')
                }

            }
            $scope.updatePersons()
        }

        $scope.changeCar = function (id) {
            for (let car of cars) {
                if (car.id === id) {
                    currentCar = car;
                    $http.get('/api/ownerships/car/' + car.id).success(function (data) {
                        let ownerships = ''
                        for (let ownership of data) {
                            ownerships += ownership.owner.id + " ,"
                        }
                        $('#add-car-ownership').val(ownerships);
                    }).error(function (data) {
                        createAlert("unable to load properties " + data, 'danger')
                    })
                    $('#add-car-modal').modal('show')
                }

            }
            $scope.updateCars()
        }
    })

/**
 * creates and appends alert
 * @param content of message
 * @param status can be success|danger|warning|info
 */
function createAlert(content, status = "info") {
    let alertClass = "alert alert-" + status;
    /*
    <div class="col">
        <div class="alert alert-info" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span
                    aria-hidden="true">×</span></button>
            <span><strong>Alert</strong> text.</span></div>
    </div>
     */
    let col = document.createElement('col')
    col.className = 'col-12'

    let alert_div = document.createElement('div')
    alert_div.className = alertClass;
    alert_div.setAttribute('role', 'alert')
    col.append(alert_div)
    let button = document.createElement('button')
    button.className = 'close'
    button.type = 'button'
    button.setAttribute('data-dismiss', 'alert')
    button.setAttribute('aria-label', 'Close')
    alert_div.append(button)

    let close = document.createElement('span')
    close.innerText = '×'
    close.setAttribute('aria-hidden', 'true')
    button.append(close)

    let span = document.createElement('span')
    span.innerHTML = "<strong>" + status.toUpperCase() + "</strong> - " + content;

    alert_div.append(span)

    document.getElementById('alerts').append(col);
}

var currentCar = null;
var currentPerson = null;
var carCreate = true;
var persons = []
var cars = []

