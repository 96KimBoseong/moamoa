package com.teamsparta.moamoa.domain.groupPurchase.controller

import com.teamsparta.moamoa.domain.groupPurchase.service.GroupPurchaseServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/groupPurchases")
class GroupPurchaseController(private val groupPurchaseServiceImpl: GroupPurchaseServiceImpl) {
//    @PostMapping("/createAndJoin")
//    fun createAndJoinOrJoin(
//        @RequestBody request: CreateGroupPurchaseRequest,
//        @RequestParam userId: Long,
//         @RequestParam orderId: Long,
//    ): ResponseEntity<String> {
//        groupPurchaseService.createAndJoinOrJoinGroupPurchase(request, userId , orderId)
//        return ResponseEntity.status(HttpStatus.OK).body("공동구매 매칭 성공")
//    }

    @PostMapping("/join")
    fun join(
        @RequestParam userId: Long,
        @RequestParam groupPurchaseId: Long,
        @RequestParam orderId: Long,
    ): ResponseEntity<Unit> {
        val groupPurchaseJoinUserResponse = groupPurchaseServiceImpl.joinGroupPurchase(userId, groupPurchaseId, orderId)
        return ResponseEntity.status(HttpStatus.OK).body(groupPurchaseJoinUserResponse)
    }

    @PutMapping("/leave")
    fun leave(
        @RequestParam userId: Long,
        @RequestParam groupPurchaseId: Long,
    ): ResponseEntity<Unit> {
        groupPurchaseServiceImpl.leaveGroupPurchase(userId, groupPurchaseId)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
}
