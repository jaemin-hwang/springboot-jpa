package com.example.demo.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleWrap is a Querydsl query type for SampleWrap
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleWrap extends EntityPathBase<SampleWrap> {

    private static final long serialVersionUID = -471391298L;

    public static final QSampleWrap sampleWrap = new QSampleWrap("sampleWrap");

    public final com.example.demo.common.model.QBaseEntity _super = new com.example.demo.common.model.QBaseEntity(this);

    //inherited
    public final EnumPath<com.example.demo.common.model.ActiveType> active = _super.active;

    //inherited
    public final NumberPath<Long> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdId = _super.createdId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Long> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedId = _super.updatedId;

    public QSampleWrap(String variable) {
        super(SampleWrap.class, forVariable(variable));
    }

    public QSampleWrap(Path<? extends SampleWrap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleWrap(PathMetadata metadata) {
        super(SampleWrap.class, metadata);
    }

}

