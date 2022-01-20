package me.zhengjie.student.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.student.domain.TbStudent;
import me.zhengjie.student.service.dto.TbStudentDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T10:05:49+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TbStudentMapperImpl implements TbStudentMapper {

    @Override
    public TbStudent toEntity(TbStudentDto dto) {
        if ( dto == null ) {
            return null;
        }

        TbStudent tbStudent = new TbStudent();

        tbStudent.setStId( dto.getStId() );
        tbStudent.setClassId( dto.getClassId() );
        tbStudent.setName( dto.getName() );
        tbStudent.setLeanTime( dto.getLeanTime() );
        tbStudent.setSex( dto.getSex() );
        tbStudent.setBirthday( dto.getBirthday() );
        tbStudent.setNativePlace( dto.getNativePlace() );
        tbStudent.setEducation( dto.getEducation() );
        tbStudent.setGraduationSchool( dto.getGraduationSchool() );
        tbStudent.setMajor( dto.getMajor() );
        tbStudent.setIdcode( dto.getIdcode() );
        tbStudent.setTelNumber( dto.getTelNumber() );
        tbStudent.setQqNumber( dto.getQqNumber() );
        tbStudent.setWxNumber( dto.getWxNumber() );
        tbStudent.setJtAddress( dto.getJtAddress() );
        tbStudent.setNowAddress( dto.getNowAddress() );
        tbStudent.setSelfContext( dto.getSelfContext() );
        tbStudent.setPhotoId( dto.getPhotoId() );

        return tbStudent;
    }

    @Override
    public TbStudentDto toDto(TbStudent entity) {
        if ( entity == null ) {
            return null;
        }

        TbStudentDto tbStudentDto = new TbStudentDto();

        tbStudentDto.setStId( entity.getStId() );
        tbStudentDto.setClassId( entity.getClassId() );
        tbStudentDto.setName( entity.getName() );
        tbStudentDto.setLeanTime( entity.getLeanTime() );
        tbStudentDto.setSex( entity.getSex() );
        tbStudentDto.setBirthday( entity.getBirthday() );
        tbStudentDto.setNativePlace( entity.getNativePlace() );
        tbStudentDto.setEducation( entity.getEducation() );
        tbStudentDto.setGraduationSchool( entity.getGraduationSchool() );
        tbStudentDto.setMajor( entity.getMajor() );
        tbStudentDto.setIdcode( entity.getIdcode() );
        tbStudentDto.setTelNumber( entity.getTelNumber() );
        tbStudentDto.setQqNumber( entity.getQqNumber() );
        tbStudentDto.setWxNumber( entity.getWxNumber() );
        tbStudentDto.setJtAddress( entity.getJtAddress() );
        tbStudentDto.setNowAddress( entity.getNowAddress() );
        tbStudentDto.setSelfContext( entity.getSelfContext() );
        tbStudentDto.setPhotoId( entity.getPhotoId() );

        return tbStudentDto;
    }

    @Override
    public List<TbStudent> toEntity(List<TbStudentDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TbStudent> list = new ArrayList<TbStudent>( dtoList.size() );
        for ( TbStudentDto tbStudentDto : dtoList ) {
            list.add( toEntity( tbStudentDto ) );
        }

        return list;
    }

    @Override
    public List<TbStudentDto> toDto(List<TbStudent> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TbStudentDto> list = new ArrayList<TbStudentDto>( entityList.size() );
        for ( TbStudent tbStudent : entityList ) {
            list.add( toDto( tbStudent ) );
        }

        return list;
    }
}
