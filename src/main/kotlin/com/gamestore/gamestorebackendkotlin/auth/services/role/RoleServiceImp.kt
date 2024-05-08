package com.gamestore.gamestorebackendkotlin.auth.services.role

import com.gamestore.gamestorebackendkotlin.auth.models.roles.RoleEntity
import com.gamestore.gamestorebackendkotlin.auth.models.roles.table.RolesEnum
import com.gamestore.gamestorebackendkotlin.auth.repository.RolesRepository
import com.gamestore.gamestorebackendkotlin.extensions.Result
import com.gamestore.gamestorebackendkotlin.extensions.ok
import org.springframework.stereotype.Service

@Service
class RoleServiceImp( val rolesRepository: RolesRepository):IRoleService {

    override fun generateRoles(): Result<String> {
        rolesRepository.generateRoles();
        return Result.ok("Все гатова")
    }

    override fun findByRole(role: RolesEnum): Result<RoleEntity?> {
        return rolesRepository.findRole(role)
    }

}