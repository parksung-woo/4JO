package com.web.service.repository;

import com.web.service.model.MemberDTO;
import com.web.service.util.PoolManager;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    //리스트
    public static List<Map<String, Object>> memberList(){

        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectList("web.service.selectMember");
    }

    //상세 정보
    public static MemberDTO memberListOne(String member_id){
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectOne("web.service.selectMemberOne", member_id);
    }

    //수정
    public static void updateMember(MemberDTO memberDTO){
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();

        session.update("web.service.updateMember", memberDTO);
        session.commit();
    }

    //삭제
    public static void deleteMember(String member_id){
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();

        session.delete("web.service.deleteMember", member_id);

        session.commit();
    }

    //가입
    public static void insertMember(MemberDTO memberDTO){
        PoolManager manager = PoolManager.getInstance();
        SqlSession session = manager.getSession();

        session.insert("web.service.insertMember", memberDTO);

        session.commit();
    }
    //로그인
    public static MemberDTO login(MemberDTO memberDTO){
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectOne("web.service.login", memberDTO);

    }
    // 중복
    public static int idCheck(String member_id){
        PoolManager manager = PoolManager.getInstance();
        return manager.getSession().selectOne("web.service.idCheck", member_id);
    }
}
