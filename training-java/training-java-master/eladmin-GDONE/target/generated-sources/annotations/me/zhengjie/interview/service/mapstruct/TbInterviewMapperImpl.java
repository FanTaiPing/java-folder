package me.zhengjie.interview.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.interview.domain.TbInterview;
import me.zhengjie.interview.service.dto.TbInterviewDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:05:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TbInterviewMapperImpl implements TbInterviewMapper {

    @Override
    public TbInterview toEntity(TbInterviewDto dto) {
        if ( dto == null ) {
            return null;
        }

        TbInterview tbInterview = new TbInterview();

        tbInterview.setInfoId( dto.getInfoId() );
        tbInterview.setName( dto.getName() );
        tbInterview.setAddress( dto.getAddress() );
        tbInterview.setCompanyType( dto.getCompanyType() );
        tbInterview.setInterviewChannel( dto.getInterviewChannel() );
        tbInterview.setInterviewPlatform( dto.getInterviewPlatform() );
        tbInterview.setPostType( dto.getPostType() );
        tbInterview.setPostName( dto.getPostName() );
        tbInterview.setInterviewTime( dto.getInterviewTime() );
        tbInterview.setPostNeed( dto.getPostNeed() );
        tbInterview.setPostSalary( dto.getPostSalary() );
        tbInterview.setCompanyStaff( dto.getCompanyStaff() );
        tbInterview.setCompanyStaffPost( dto.getCompanyStaffPost() );
        tbInterview.setCompanyStaffTell( dto.getCompanyStaffTell() );
        tbInterview.setCompanyStaffWx( dto.getCompanyStaffWx() );
        tbInterview.setCompanyStaffQq( dto.getCompanyStaffQq() );
        tbInterview.setResult( dto.getResult() );
        tbInterview.setResultDesc( dto.getResultDesc() );
        tbInterview.setFeeling( dto.getFeeling() );
        tbInterview.setIsFrist( dto.getIsFrist() );
        tbInterview.setIsNext( dto.getIsNext() );
        tbInterview.setIsLy( dto.getIsLy() );
        tbInterview.setInterviewTimes( dto.getInterviewTimes() );
        tbInterview.setQ1( dto.getQ1() );
        tbInterview.setA1( dto.getA1() );
        tbInterview.setQ2( dto.getQ2() );
        tbInterview.setA2( dto.getA2() );
        tbInterview.setQ3( dto.getQ3() );
        tbInterview.setA3( dto.getA3() );
        tbInterview.setQ4( dto.getQ4() );
        tbInterview.setA4( dto.getA4() );
        tbInterview.setQ5( dto.getQ5() );
        tbInterview.setA5( dto.getA5() );
        tbInterview.setQ6( dto.getQ6() );
        tbInterview.setA6( dto.getA6() );

        return tbInterview;
    }

    @Override
    public TbInterviewDto toDto(TbInterview entity) {
        if ( entity == null ) {
            return null;
        }

        TbInterviewDto tbInterviewDto = new TbInterviewDto();

        tbInterviewDto.setInfoId( entity.getInfoId() );
        tbInterviewDto.setName( entity.getName() );
        tbInterviewDto.setAddress( entity.getAddress() );
        tbInterviewDto.setCompanyType( entity.getCompanyType() );
        tbInterviewDto.setInterviewChannel( entity.getInterviewChannel() );
        tbInterviewDto.setInterviewPlatform( entity.getInterviewPlatform() );
        tbInterviewDto.setPostType( entity.getPostType() );
        tbInterviewDto.setPostName( entity.getPostName() );
        tbInterviewDto.setInterviewTime( entity.getInterviewTime() );
        tbInterviewDto.setPostNeed( entity.getPostNeed() );
        tbInterviewDto.setPostSalary( entity.getPostSalary() );
        tbInterviewDto.setCompanyStaff( entity.getCompanyStaff() );
        tbInterviewDto.setCompanyStaffPost( entity.getCompanyStaffPost() );
        tbInterviewDto.setCompanyStaffTell( entity.getCompanyStaffTell() );
        tbInterviewDto.setCompanyStaffWx( entity.getCompanyStaffWx() );
        tbInterviewDto.setCompanyStaffQq( entity.getCompanyStaffQq() );
        tbInterviewDto.setResult( entity.getResult() );
        tbInterviewDto.setResultDesc( entity.getResultDesc() );
        tbInterviewDto.setFeeling( entity.getFeeling() );
        tbInterviewDto.setIsFrist( entity.getIsFrist() );
        tbInterviewDto.setIsNext( entity.getIsNext() );
        tbInterviewDto.setIsLy( entity.getIsLy() );
        tbInterviewDto.setInterviewTimes( entity.getInterviewTimes() );
        tbInterviewDto.setQ1( entity.getQ1() );
        tbInterviewDto.setA1( entity.getA1() );
        tbInterviewDto.setQ2( entity.getQ2() );
        tbInterviewDto.setA2( entity.getA2() );
        tbInterviewDto.setQ3( entity.getQ3() );
        tbInterviewDto.setA3( entity.getA3() );
        tbInterviewDto.setQ4( entity.getQ4() );
        tbInterviewDto.setA4( entity.getA4() );
        tbInterviewDto.setQ5( entity.getQ5() );
        tbInterviewDto.setA5( entity.getA5() );
        tbInterviewDto.setQ6( entity.getQ6() );
        tbInterviewDto.setA6( entity.getA6() );

        return tbInterviewDto;
    }

    @Override
    public List<TbInterview> toEntity(List<TbInterviewDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TbInterview> list = new ArrayList<TbInterview>( dtoList.size() );
        for ( TbInterviewDto tbInterviewDto : dtoList ) {
            list.add( toEntity( tbInterviewDto ) );
        }

        return list;
    }

    @Override
    public List<TbInterviewDto> toDto(List<TbInterview> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TbInterviewDto> list = new ArrayList<TbInterviewDto>( entityList.size() );
        for ( TbInterview tbInterview : entityList ) {
            list.add( toDto( tbInterview ) );
        }

        return list;
    }
}
