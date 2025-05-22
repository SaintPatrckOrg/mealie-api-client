package com.saintpatrck.mealie.client.api.households.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Models a general event notification.
 *
 * @param id The ID of the event notification
 * @param name The name of the event notification
 * @param enabled Whether the event notification is enabled
 * @param groupId The ID of the group the event notification belongs to
 * @param householdId The ID of the household the event notification belongs to
 * @param options A list of options for the event notification
 */
@Serializable
data class EventNotificationJson(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("enabled")
    val enabled: Boolean,
    @SerialName("groupId")
    val groupId: String,
    @SerialName("householdId")
    val householdId: String,
    @SerialName("options")
    val options: List<EventNotificationOptionJson>,
) {
    /**
     * Options Model
     *
     * Describes an individual options entry
     */
    @Serializable
    data class EventNotificationOptionJson(
        @SerialName("testMessage")
        val testMessage: Boolean,
        @SerialName("webhookTask")
        val webhookTask: Boolean,
        @SerialName("recipeCreated")
        val recipeCreated: Boolean,
        @SerialName("recipeUpdated")
        val recipeUpdated: Boolean,
        @SerialName("recipeDeleted")
        val recipeDeleted: Boolean,
        @SerialName("userSignup")
        val userSignup: Boolean,
        @SerialName("dataMigrations")
        val dataMigrations: Boolean,
        @SerialName("dataExport")
        val dataExport: Boolean,
        @SerialName("dataImport")
        val dataImport: Boolean,
        @SerialName("mealplanEntryCreated")
        val mealplanEntryCreated: Boolean,
        @SerialName("shoppingListCreated")
        val shoppingListCreated: Boolean,
        @SerialName("shoppingListUpdated")
        val shoppingListUpdated: Boolean,
        @SerialName("shoppingListDeleted")
        val shoppingListDeleted: Boolean,
        @SerialName("cookbookCreated")
        val cookbookCreated: Boolean,
        @SerialName("cookbookUpdated")
        val cookbookUpdated: Boolean,
        @SerialName("cookbookDeleted")
        val cookbookDeleted: Boolean,
        @SerialName("tagCreated")
        val tagCreated: Boolean,
        @SerialName("tagUpdated")
        val tagUpdated: Boolean,
        @SerialName("tagDeleted")
        val tagDeleted: Boolean,
        @SerialName("categoryCreated")
        val categoryCreated: Boolean,
        @SerialName("categoryUpdated")
        val categoryUpdated: Boolean,
        @SerialName("categoryDeleted")
        val categoryDeleted: Boolean,
        @SerialName("id")
        val id: String,
    )
}
