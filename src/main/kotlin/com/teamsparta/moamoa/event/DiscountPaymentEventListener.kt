package com.teamsparta.moamoa.event

import com.teamsparta.moamoa.domain.groupPurchase.service.GroupPurchaseServiceImpl
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class DiscountPaymentEventListener(private val groupPurchaseServiceImpl: GroupPurchaseServiceImpl) {
    @Async
    @EventListener
    fun handleDiscountAppliedEvent(event: DiscountPaymentEvent) {
        groupPurchaseServiceImpl.createAndJoinOrJoinGroupPurchase(event.orderId, event.userId)
    }
}
