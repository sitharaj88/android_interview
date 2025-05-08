package com.sitharaj.userlist.data.mapper

import com.sitharaj.userlist.data.remote.dto.UserDto
import com.sitharaj.userlist.domain.model.Address
import com.sitharaj.userlist.domain.model.Company
import com.sitharaj.userlist.domain.model.Geo
import com.sitharaj.userlist.domain.model.User


fun UserDto.toDomain(): User = User(
    id, name, username, email,
    Address(address.street, address.suite, address.city, address.zipcode, Geo(address.geo.lat, address.geo.lng)),
    phone, website,
    Company(company.name, company.catchPhrase, company.bs)
)
