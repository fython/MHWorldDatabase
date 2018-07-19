package com.gatheringhallstudios.mhworlddatabase.data.models

import android.arch.persistence.room.Embedded
import com.gatheringhallstudios.mhworlddatabase.data.entities.LocationItemEntity
import com.gatheringhallstudios.mhworlddatabase.data.types.ItemCategory
import com.gatheringhallstudios.mhworlddatabase.data.types.ItemSubcategory

/**
 * The base model for an item containing the basic identifying information
 */
open class ItemBase(
        val id: Int,
        val name: String,
        val icon_name: String?,
        val icon_color: String?
)

/**
 * Full information regarding an item model
 */
class Item(
        id: Int,
        name: String,
        icon_name: String?,
        icon_color: String?,

        val description: String?,
        val category: ItemCategory,
        val subcategory: ItemSubcategory,
        val rarity: Int,
        val buy_price: Int?,
        val sell_price: Int,
        val carry_limit: Int?
): ItemBase(id, name, icon_name, icon_color)

class ItemCombination(
        val id: Int,
        @Embedded(prefix = "result_") val result: ItemBase,
        @Embedded(prefix = "first_") val first: ItemBase,
        @Embedded(prefix = "second_") val second: ItemBase?,
        val quantity: Int
)

class ItemLocation(
        @Embedded val data: LocationItemEntity,
        val location_name: String
)