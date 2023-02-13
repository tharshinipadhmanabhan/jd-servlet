function refresh() {
    location.reload();
}

function indexRedirect() {
    location.href = "index.jsp";
}

function register() {
    let datas = {
        ad_name: document.getElementById("ad_name").value,
        contactNum: document.getElementById("contact_num").value,
        category: document.getElementById("catSelect").value,
        subCategory: document.getElementById("subCatSelect").value,
        f_d_num: document.getElementById("f_d_num").value,
        area: document.getElementById("area").value,
        city: document.getElementById("city").value,
        district: document.getElementById("district").value,
        state: document.getElementById("state").value,
        country: document.getElementById("county").value,
        opnTime: document.getElementById("opn_time").value,
        clsTime: document.getElementById("close_time").value,
        holiday: document.getElementById("holiday").value,
        desc: document.getElementById("description").value
    }
    console.log(datas);

    $.ajax({
        url: "http://localhost:9090/register",
        type: "POST",
        data: JSON.stringify(datas),

        success: function (result) {
            if (result != "Error") {
                location.href = result;
            }
            else {
                location.reload();
            }
        },

        error: function (error) {
            console.log(`Error ${error}`);
        },
    })
}

function signinClicked() {
    let fName = document.getElementById("firstName").value;
    let lName = document.getElementById("lastName").value;
    let phnNum = document.getElementById("phnNum").value;
    let pass1 = document.getElementById("pass1").value;
    let conPass = document.getElementById("conPass").value;


    let datas = {
        first_name: fName,
        last_name: lName,
        phone_num: phnNum,
        password: pass1,
        confirm_password: conPass
    }

    $.ajax({
        url: "http://localhost:9090/signin",
        type: "POST",
        data: datas,

        success: function (result) {
            location.reload();
        },

        error: function (error) {
            console.log(`Error ${error}`);
        },
    })
}

function selectDisplay() {

    $.ajax({
        url: "http://localhost:9090/category",
        type: "GET",
        dataType: "json",

        success: function (data) {
            console.log(data);
            displayOptions(data);
        },

        error: function (error) {
            console.log(`Error ${error}`);
        },
    })
}

function displayOptions(data) {
    let catSelect = document.getElementById("catSelect");

    data.forEach(element => {
        let option = document.createElement("option");
        option.innerHTML = element.category.toUpperCase();
        catSelect.appendChild(option);
    });
}

function subCatSelect() {
    let catSelect = document.getElementById("catSelect").value;

    let select_item = document.getElementById('subCatSelect');
    let options = select_item.getElementsByTagName('option');

    for(let i = 0;i <= options.length + 1; i++){
        Array.prototype.forEach.call(options, (elem) => {
            select_item.removeChild(elem);
        });
    }


    $.ajax({
        url: "http://localhost:9090/category",
        type: "POST",
        dataType: "json",
        data: { a: catSelect },

        success: function (result) {
            console.log(result);
            displaySubCatOptions(result);
        },

        error: function (error) {
            console.log(`Error ${error}`);
        },
    })
}

function displaySubCatOptions(data) {
    let subCatSelect = document.getElementById("subCatSelect");

    let option = document.createElement("option");
        option.innerHTML = "Select Sub-Category";
        subCatSelect.appendChild(option);

    data.forEach(element => {
        let option = document.createElement("option");
        option.innerHTML = element.subCategory.toUpperCase();
        subCatSelect.appendChild(option);
    });
}

function search() {

    let cat = document.getElementById("catSelect").value;
    let subCat = document.getElementById("subCatSelect").value;


    let datas = {
        category: cat,
        subCat: subCat
    }

    $.ajax({
        url: "http://localhost:9090/search",
        type: "POST",
        dataType: "json",
        data: datas,

        success: function (result) {
            console.log(result);
            displayRslt(result);
        },

        error: function (error) {
            console.log(`Error ${error}`);
        },
    })
}

function displayRslt(data) {
    let allAdDiv = document.getElementById("allAdDiv");
    let rsltDiv = document.getElementById("rsltDiv");
    let searchRsltCheck = document.getElementById("searchRslt");

    if(searchRsltCheck != null){
        searchRsltCheck.remove();
    }

    if(allAdDiv != null){
        allAdDiv.remove();
    }

    let searchRslt = document.createElement("div");
    searchRslt.setAttribute("class","m-3")
    searchRslt.setAttribute("id","searchRslt");
    rsltDiv.appendChild(searchRslt);

    let heading = document.createElement("h2");
    heading.innerHTML = "Result";
    searchRslt.appendChild(heading);

    let itemCard = document.createElement("div");
    itemCard.setAttribute("class", "row");
    searchRslt.appendChild(itemCard);

    data.forEach(element => {

        let itemCardRow = document.createElement("div");
        itemCardRow.setAttribute("class", "col-6 p-3 row g-0");
        itemCard.appendChild(itemCardRow);

        let itemCardImg = document.createElement("div");
        itemCardImg.setAttribute("class", "col-md-5 bg-danger");
        itemCardRow.appendChild(itemCardImg);

        let itemCardContent = document.createElement("div");
        itemCardContent.setAttribute("class", "bg-white col-md-7 p-3");
        itemCardRow.appendChild(itemCardContent);

        let itemCardBody = document.createElement("div");
        itemCardBody.setAttribute("class", "card-body p-0 mb-2");
        itemCardContent.appendChild(itemCardBody);


        let itemName = document.createElement("h1");
        itemName.innerHTML = element.ad_name.toUpperCase();
        itemName.setAttribute("class", "card-title");
        itemCardBody.appendChild(itemName);

        let itemLocation = document.createElement("p");
        itemLocation.innerHTML = element.area.toUpperCase() + ", " + element.city.toUpperCase();
        itemLocation.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemLocation);

        let itemDesc = document.createElement("p");
        itemDesc.innerHTML = element.desc.toUpperCase();
        itemDesc.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemDesc);

        let itemTime = document.createElement("p");
        itemTime.innerHTML = (element.opnTime).slice(0, 5) + " " + (element.opnTime).slice(8, 11) + " - " + (element.clsTime).slice(0, 5) + " " + (element.clsTime).slice(8, 11);
        itemTime.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemTime);

        let itemHoliday = document.createElement("p");
        itemHoliday.innerHTML = "HOLIDAY: " + element.holiday.toUpperCase();
        itemHoliday.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemHoliday);
    });
}

function getAll() {
    $.ajax({
        url: "http://localhost:9090/register",
        type: "GET",
        dataType: "json",

        success: function (data) {
            console.log(data);
            displayCards(data);
            selectDisplay();
        },

        error: function (error) {
            console.log(`Error ${error}`);
        },
    })
}

function displayCards(data) {
    let mainCardDiv = document.getElementById("mainCardDiv");

    let itemCard = document.createElement("div");
    itemCard.setAttribute("class", "row");
    mainCardDiv.appendChild(itemCard);

    data.forEach(element => {

        let itemCardRow = document.createElement("div");
        itemCardRow.setAttribute("class", "col-6 p-3 row g-0");
        itemCard.appendChild(itemCardRow);

        let itemCardImg = document.createElement("div");
        itemCardImg.setAttribute("class", "col-md-5 bg-danger");
        itemCardRow.appendChild(itemCardImg);

        let itemCardContent = document.createElement("div");
        itemCardContent.setAttribute("class", "bg-white col-md-7 p-3");
        itemCardRow.appendChild(itemCardContent);

        let itemCardBody = document.createElement("div");
        itemCardBody.setAttribute("class", "card-body p-0 mb-2");
        itemCardContent.appendChild(itemCardBody);


        let itemName = document.createElement("h1");
        itemName.innerHTML = element.ad_name.toUpperCase();
        itemName.setAttribute("class", "card-title");
        itemCardBody.appendChild(itemName);

        let itemLocation = document.createElement("p");
        itemLocation.innerHTML = element.area.toUpperCase() + ", " + element.city.toUpperCase();
        itemLocation.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemLocation);

        let itemDesc = document.createElement("p");
        itemDesc.innerHTML = element.desc.toUpperCase();
        itemDesc.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemDesc);

        let itemTime = document.createElement("p");
        itemTime.innerHTML = (element.opnTime).slice(0, 5) + " " + (element.opnTime).slice(8, 11) + " - " + (element.clsTime).slice(0, 5) + " " + (element.clsTime).slice(8, 11);
        itemTime.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemTime);

        let itemHoliday = document.createElement("p");
        itemHoliday.innerHTML = "HOLIDAY: " + element.holiday.toUpperCase();
        itemHoliday.setAttribute("class", "card-text");
        itemCardBody.appendChild(itemHoliday);
    });


}