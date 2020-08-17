package com.web.service.repository;

import com.web.service.model.MemberDTO;
import com.web.service.util.PoolManager;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author Jeon Jin Ho
 * @date 20-08-13
 */

@Repository
public class MemberRepository {

    /**
     * 웹으로 리스트 (DAO)
     * @return manager.getSession().selectList("web.service.selectMember")
     * : - DB에 있는 값을 id가 selectMember인 SQL문을 통해 조작
     */
    public static List<Map<String, Object>> memberList() {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectMember");
    }

    /**
     * 상세 정보 (DAO)
     * @param member_id : 회원 아이디
     * @return manager.getSession().selectOne("web.service.selectMemberOne", member_id)
     * : -DB에 있는 값을 id가 selectMemberOne인 SQL문을 통해 조작
     *    (조건 : member_id 즉, 상세정보를 보고싶은 회원 아이디를 조건 설정)
     */
    public static MemberDTO memberListOne(String member_id) {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectOne("web.service.selectMemberOne", member_id);
    }

    /**
     * 상세정보에 있는 수정 부분
     * @param memberDTO : 수정한 정보를 담음
     */
    public static void updateMember(MemberDTO memberDTO) {
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();
        session.update("web.service.updateMember", memberDTO);
        session.commit();
    }

    /**
     * 목록 출력웹페이지 에서 삭제 부분
     * @param member_id : 삭제 하고 싶은 회원 아이디
     */
    /*삭제*/
    public static void deleteMember(String member_id) {
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();
        session.delete("web.service.deleteMember", member_id);
        session.commit();
    }

    /**
     * 안드로이드에서 보낸 회원 정보를 저장및 DB commit (회원 가입, 변경된 DB값을 저장)
     * @param memberDTO : 변경된 회원 정보를 담음
     */
    @NotBlank
    public static void insertMember(MemberDTO memberDTO) {
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();
        session.insert("web.service.insertMember", memberDTO);
        session.commit();
    }

    /**
     * 안드로이드 로그인
     * @param memberDTO : 회원정보를 담음
     * @return manager.getSession().selectOne("web.service.login", memberDTO)
     * : -DB에 있는 값을 id가 login인 SQL문을 통해 조작
     *    (memberDTO에 회원 아이디와 비밀 번호 정보를 담음)
     */
    public static MemberDTO login(MemberDTO memberDTO) {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectOne("web.service.login", memberDTO);

    }

    /**
     *
     * @param member_id
     * @return
     */
    /*안드로이드 중복 체크*/
    public static int idCheck(String member_id) {
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectOne("web.service.idCheck", member_id);
    }
}
