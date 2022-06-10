package com.example.model.responses

import com.example.model.request.RequestStatus

@kotlinx.serialization.Serializable
data class ResponseMessage(var status: RequestStatus, var message:String)