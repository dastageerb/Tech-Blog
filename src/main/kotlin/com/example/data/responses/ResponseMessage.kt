package com.example.data.responses

import com.example.data.request.RequestStatus

@kotlinx.serialization.Serializable
data class ResponseMessage(var status:RequestStatus,var message:String)