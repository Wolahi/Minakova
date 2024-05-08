package com.gamestore.gamestorebackendkotlin.auth.repository

import com.gamestore.gamestorebackendkotlin.auth.errors.CommonError
import com.gamestore.gamestorebackendkotlin.auth.errors.ErrorType
import com.gamestore.gamestorebackendkotlin.auth.models.roles.RoleEntity
import com.gamestore.gamestorebackendkotlin.auth.models.roles.table.RoleTable
import com.gamestore.gamestorebackendkotlin.auth.models.roles.table.RolesEnum
import com.gamestore.gamestorebackendkotlin.extensions.Result
import com.gamestore.gamestorebackendkotlin.extensions.error
import com.gamestore.gamestorebackendkotlin.extensions.ok
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class RolesRepository {

    fun generateRoles() {
        val roles = RolesEnum.entries.toTypedArray();
        roles.forEach { role ->
            transaction {
                RoleEntity.new {
                    roleName = role
                }
            }
        }
    }

    fun findRole(role: RolesEnum): Result<RoleEntity?> {
        val roleEntity = RoleEntity.find(RoleTable.roleEnum.eq(role)).firstOrNull()
        return Result.ok(roleEntity);
    }
}