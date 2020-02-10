package fr.isen.dylanmetans.androidtoolbox

class UserModel {
    var gender: String? = null
    var name: NameModel? = null
    var location: LocationModel? = null
    var email: String? = null
    var picture: PictureModel? = null
}

class NameModel {
    var title: String? = null
    var first: String? = null
    var last: String? = null
}

class LocationModel {
    var city: String? = null
    var state: String? = null
    var country: String? = null
    var street: StreetModel? = null
}

class PictureModel {
    var large: String? = null
    var medium: String? = null
    var thumbnail: String? = null
}

class StreetModel {
    var name: String? = null
}

