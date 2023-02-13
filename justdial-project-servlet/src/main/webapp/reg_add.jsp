<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>


    <link rel="stylesheet" href="index.css">
    <script src="index.js"></script>
</head>

<body onload="selectDisplay()">
    <div class="d-flex flex-row justify-content-center p-5">
        <div class="d-flex flex-column d-grid gap-3 w-75 p-5 border border-secondary">
            <h2>Enter Your Details Below</h2>
            <hr>

            <input type="text" class="form-control mt-5" name="ad_name" id="ad_name" placeholder="Enter Add Name">
            <input type="text" class="form-control" name="contact_num" id="contact_num"
                placeholder="Enter Contact Number">

            <select class="form-select" id="catSelect" name="catSelect" onchange="subCatSelect()">
                <option selected disabled>Select Category</option>
            </select>
            <select class="form-select col-4" id="subCatSelect" name="subCatSelect">
                <option selected disabled>Select Sub Category</option>
            </select>

            <h4 class="mb-0 mt-3">Address :</h4>
            <input type="text" class="form-control" name="f_d_num" id="f_d_num" placeholder="Enter Flat/Door Number">
            <input type="text" class="form-control" name="area" id="area" placeholder="Enter Area">
            <input type="text" class="form-control" name="city" id="city" placeholder="Enter City">
            <input type="text" class="form-control" name="district" id="district" placeholder="Enter District">
            <input type="text" class="form-control" name="state" id="state" placeholder="Enter State">
            <input type="text" class="form-control" name="county" id="county" placeholder="Enter County">

            <h4 class="mb-0 mt-3">Timings :</h4>
            <div class="row">
                <div class="col-4">
                    <label class="mb-2" for="opn_time">Open Time</label>
                    <input type="time" class="form-control" name="opn_time" id="opn_time">
                </div>
                <div class="col-4">
                    <label class="mb-2" for="close_time">Close Time</label>
                    <input type="time" class="form-control" name="close_time" id="close_time">
                </div>
            </div>

            <h4 class="mb-0 mt-3">Holiday :</h4>
            <select class="form-select" id="holiday">
                <option value="sunday">Sunday</option>

                <option value="monday">Monday</option>

                <option value="tuesday">Tuesday</option>

                <option value="wednesday">Wednesday</option>

                <option value="thursday">Thursday</option>

                <option value="friday">Friday</option>
            </select>


            <h4 class="mb-0 mt-3">Description :</h4>
            <textarea type="text" class="form-control" name="description" id="description"
                placeholder="Enter Description"></textarea>

            <div class="row mt-5">
                <div class="d-flex flex-row justify-content-start col-6">
                    <button class="btn btn-secondary" onclick="indexRedirect()">Cancel</button>
                </div>

                <div class="d-flex flex-row justify-content-end col-6">
                    <button class="btn btn-primary" onclick="register()">Submit</button>
                </div>
            </div>
        </div>
    </div>
</body>

</html>