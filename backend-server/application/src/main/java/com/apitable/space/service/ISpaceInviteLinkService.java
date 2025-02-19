/*
 * APITable <https://github.com/apitable/apitable>
 * Copyright (C) 2022 APITable Ltd. <https://apitable.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.apitable.space.service;

import java.util.Collection;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import com.apitable.space.vo.SpaceLinkInfoVo;
import com.apitable.space.dto.InvitationUserDTO;
import com.apitable.space.entity.SpaceInviteLinkEntity;
import com.apitable.space.vo.SpaceLinkVo;

public interface ISpaceInviteLinkService extends IService<SpaceInviteLinkEntity> {

    /**
     * Get space link vos.
     *
     * @param memberId  member table id
     * @return List<SpaceLinkVo>
     * @author Chambers
     */
    List<SpaceLinkVo> getSpaceLinkVos(Long memberId);

    /**
     * Generate or refresh links
     *
     * @param spaceId space id
     * @param teamId   teamId
     * @param memberId memberId
     * @return invite link token
     */
    String saveOrUpdate(String spaceId, Long teamId, Long memberId);

    /**
     * check invite link token
     *
     * @param token invite link token
     * @return info
     */
    SpaceLinkInfoVo valid(String token);

    /**
     * Join the space using the public link
     *
     * @param userId userId
     * @param token  invite link token
     */
    void join(Long userId, String token, String nodeId);

    /**
     * user invites to join space station and assigns updater privileges
     * @param token invitation token
     * @param userId userID that should be added to the space station
     * @return InvitationUserDTO
     */
    InvitationUserDTO invitedUserJoinSpaceByToken(Long userId, String token);

    /**
     * Delete links generated by members that do not have member administration permissions
     *
     * @param spaceId space id
     */
    void delNoPermitMemberLink(String spaceId);

    /**
     * When the function of inviting all members of the space is turned off,
     * all public invitation links generated by the member become invalid.
     *
     * @param spaceId space id
     * @param memberId memberId
     */
    void delByMemberIdIfNotInvite(String spaceId, Long memberId);

    /**
     * logically delete
     * @param memberIds memberIds
     */
    void deleteByMemberIds(List<Long> memberIds);

    /**
     * Delete by team id and member id.
     *
     * @param teamId    team table id
     * @param memberId  member table id
     * @author Chambers
     */
    void deleteByTeamIdAndMemberId(Long teamId, Long memberId);

    /**
     * @param teamIds teamIds
     */
    void deleteByTeamIds(Collection<Long> teamIds);
}
