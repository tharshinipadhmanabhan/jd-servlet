<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Justdial</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
        integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>


    <link rel="stylesheet" href="index.css">
    <script src="index.js"></script>
</head>

<body class="bg-secondary p-5" onload="getAll()">
    <div class="mainDiv">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <img src="./images/JustDial_Logo.png" alt="" srcset="" class="navLogo" onclick="refresh()">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav ms-auto">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                        <a class="nav-link" href="reg_add.jsp">Advertise</a>
                        <a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal">Login</a>
                        <a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal1">Signin</a>
                    </div>
                </div>
            </div>
        </nav>
        <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./images/logistic-banner-web.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./images/lupin_1.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./images/Flights.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./images/jdbannerweb.webp" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="./images/cs_mbanner_4.webp" class="d-block w-100" alt="...">
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row d-flex justify-content-center mt-3 mb-3">
                <div class="col-4 ms-3">
                    <select class="form-select" id="catSelect" name="catSelect" onchange="subCatSelect()">
                        <option selected disabled>Select Category</option>
                    </select>
                </div>

                <div class="col-4 ms-5">
                    <select class="form-select col-4" id="subCatSelect" name="subCatSelect">
                        <option selected disabled>Select Sub Category</option>
                    </select>
                </div>

                <div class="col-3 d-flex flex-row justify-content-center">
                    <button class="btn btn-success w-50" onclick="search()">Search</button>
                </div>

            </div>

            <div class="row">
                <div class="col-12">
                    <div id="rsltDiv">
                        
                    </div>
                </div>
            </div>

            <div class="row p-3" id="allAdDiv" onload="getAll()">
                <div class="col-12">
                    <div class="3">
                        <h2>All Ads</h2>
                        <div id="mainCardDiv">

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="bg-dark">
            <p class="fw-normal text-white text-center m-5">Developed By JS <i class="fa-regular fa-copyright ms-1"></i>
            </p>
        </div>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog w-25">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="container">
                        <div class="row">
                            <div class="d-flex flex-row justify-content-center">
                                <img src="./images/JustDial_Logo.png" class="navLogo" />
                            </div>
                        </div>
                        <div class="d-flex flex-row justify-content-center">
                            <p class="text-secondary">Login for seamless experience</p>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div>
                        <div class="d-flex flex-column d-grid gap-3 mt-3">
                            <input type="text" class="form-control" name="userName" id="userName"
                                placeholder="User Name">
                            <input type="text" class="form-control" name="pass" id="pass" placeholder="Password">
                        </div>
                        <div class="d-flex flex-row mt-2">
                            <input type="checkbox" name="rememberMe" id="rememberMe">
                            <label class="ms-2" for="rememberMe">Remember Me</label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Login</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog w-25">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="container">
                        <div class="row">
                            <div class="d-flex flex-row justify-content-center">
                                <img src="./images/JustDial_Logo.png" class="navLogo" />
                            </div>
                        </div>
                        <div class="d-flex flex-row justify-content-center">
                            <p class="text-secondary">Signin for seamless experience</p>
                        </div>
                    </div>
                </div>
                <div class="modal-body">
                    <div>
                        <div class="d-flex flex-column d-grid gap-3 mt-3 mb-3">
                            <input type="text" class="form-control" name="firstName" id="firstName"
                                placeholder="First Name">
                            <input type="text" class="form-control" name="lastName" id="lastName"
                                placeholder="Last Name">
                            <input type="text" class="form-control" name="phnNum" id="phnNum"
                                placeholder="Phone Number">
                            <input type="text" class="form-control" name="pass1" id="pass1"
                                placeholder="Enter Password">
                            <input type="text" class="form-control" name="conPass" id="conPass"
                                placeholder="Confirm Password">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="signinClicked()">Signin</button>
                </div>
            </div>
        </div>
    </div>
    <div>

    </div>
</body>

</html>