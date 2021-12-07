let states = ["AK",
    "AL",
    "AR",
    "AS",
    "AZ",
    "CA",
    "CO",
    "CT",
    "DC",
    "DE",
    "FL",
    "GA",
    "GU",
    "HI",
    "IA",
    "ID",
    "IL",
    "IN",
    "KS",
    "KY",
    "LA",
    "MA",
    "MD",
    "ME",
    "MI",
    "MN",
    "MO",
    "MS",
    "MT",
    "NC",
    "ND",
    "NE",
    "NH",
    "NJ",
    "NM",
    "NV",
    "NY",
    "OH",
    "OK",
    "OR",
    "PA",
    "PR",
    "RI",
    "SC",
    "SD",
    "TN",
    "TX",
    "UT",
    "VA",
    "VI",
    "VT",
    "WA",
    "WI",
    "WV",
    "WY"]

$.each(states, function (i, state) {
    $('#state').append($('<option>', {
        text : state
    }));
});

$("#itemInput").change(function() {
    var itemSearch = $("#itemInput").val();
    var obj = $("#itemOptions").find("option[value='" + itemSearch + "']");

    if (obj != null && obj.length > 0) {
        $("#priceInput").attr("readonly", true);
        $("#priceInput").val(obj.attr("price")); // load value here
        alert("disables price and loads generated price..")
    } else {
        $("#priceInput").attr("readonly", false);
        $("#priceInput").val("");
        $("#priceInput").attr("placeholder", "Enter desired price...");
        alert("invalid");
    }
});

$("#formFileMultiple").change(function() {
    Array.prototype.forEach.call(this.files, function(file) {
        // for some reason, it will only validate with === and not !=
        if (file.type.toString() === "image/jpeg" || file.type.toString() === "image/png") {
            alert("success");
        } else {
            alert("INVALID TYPE!!!! " + file.type)
            $("#formFileMultiple").val(null);
        }
    });
});