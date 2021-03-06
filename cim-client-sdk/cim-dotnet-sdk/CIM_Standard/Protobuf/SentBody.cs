// <auto-generated>
//     Generated by the protocol buffer compiler.  DO NOT EDIT!
//     source: SentBody.proto
// </auto-generated>
#pragma warning disable 1591, 0612, 3021
#region Designer generated code

using pb = global::Google.Protobuf;
using pbc = global::Google.Protobuf.Collections;
using pbr = global::Google.Protobuf.Reflection;
using scg = global::System.Collections.Generic;
/// <summary>Holder for reflection information generated from SentBody.proto</summary>
public static partial class SentBodyReflection {

  #region Descriptor
  /// <summary>File descriptor for SentBody.proto</summary>
  public static pbr::FileDescriptor Descriptor {
    get { return descriptor; }
  }
  private static pbr::FileDescriptor descriptor;

  static SentBodyReflection() {
    byte[] descriptorData = global::System.Convert.FromBase64String(
        string.Concat(
          "Cg5TZW50Qm9keS5wcm90byJ0CgVNb2RlbBILCgNrZXkYASABKAkSEQoJdGlt",
          "ZXN0YW1wGAIgASgDEh4KBGRhdGEYAyADKAsyEC5Nb2RlbC5EYXRhRW50cnka",
          "KwoJRGF0YUVudHJ5EgsKA2tleRgBIAEoCRINCgV2YWx1ZRgCIAEoCToCOAFi",
          "BnByb3RvMw=="));
    descriptor = pbr::FileDescriptor.FromGeneratedCode(descriptorData,
        new pbr::FileDescriptor[] { },
        new pbr::GeneratedClrTypeInfo(null, null, new pbr::GeneratedClrTypeInfo[] {
          new pbr::GeneratedClrTypeInfo(typeof(global::SentBodyModel), global::SentBodyModel.Parser, new[]{ "Key", "Timestamp", "Data" }, null, null, null, new pbr::GeneratedClrTypeInfo[] { null, })
        }));
  }
  #endregion

}
#region Messages
public sealed partial class SentBodyModel : pb::IMessage<SentBodyModel>
#if !GOOGLE_PROTOBUF_REFSTRUCT_COMPATIBILITY_MODE
    , pb::IBufferMessage
#endif
{
  private static readonly pb::MessageParser<SentBodyModel> _parser = new pb::MessageParser<SentBodyModel>(() => new SentBodyModel());
  private pb::UnknownFieldSet _unknownFields;
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public static pb::MessageParser<SentBodyModel> Parser { get { return _parser; } }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public static pbr::MessageDescriptor Descriptor {
    get { return global::SentBodyReflection.Descriptor.MessageTypes[0]; }
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  pbr::MessageDescriptor pb::IMessage.Descriptor {
    get { return Descriptor; }
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public SentBodyModel() {
    OnConstruction();
  }

  partial void OnConstruction();

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public SentBodyModel(SentBodyModel other) : this() {
    key_ = other.key_;
    timestamp_ = other.timestamp_;
    data_ = other.data_.Clone();
    _unknownFields = pb::UnknownFieldSet.Clone(other._unknownFields);
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public SentBodyModel Clone() {
    return new SentBodyModel(this);
  }

  /// <summary>Field number for the "key" field.</summary>
  public const int KeyFieldNumber = 1;
  private string key_ = "";
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public string Key {
    get { return key_; }
    set {
      key_ = pb::ProtoPreconditions.CheckNotNull(value, "value");
    }
  }

  /// <summary>Field number for the "timestamp" field.</summary>
  public const int TimestampFieldNumber = 2;
  private long timestamp_;
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public long Timestamp {
    get { return timestamp_; }
    set {
      timestamp_ = value;
    }
  }

  /// <summary>Field number for the "data" field.</summary>
  public const int DataFieldNumber = 3;
  private static readonly pbc::MapField<string, string>.Codec _map_data_codec
      = new pbc::MapField<string, string>.Codec(pb::FieldCodec.ForString(10, ""), pb::FieldCodec.ForString(18, ""), 26);
  private readonly pbc::MapField<string, string> data_ = new pbc::MapField<string, string>();
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public pbc::MapField<string, string> Data {
    get { return data_; }
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public override bool Equals(object other) {
    return Equals(other as SentBodyModel);
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public bool Equals(SentBodyModel other) {
    if (ReferenceEquals(other, null)) {
      return false;
    }
    if (ReferenceEquals(other, this)) {
      return true;
    }
    if (Key != other.Key) return false;
    if (Timestamp != other.Timestamp) return false;
    if (!Data.Equals(other.Data)) return false;
    return Equals(_unknownFields, other._unknownFields);
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public override int GetHashCode() {
    int hash = 1;
    if (Key.Length != 0) hash ^= Key.GetHashCode();
    if (Timestamp != 0L) hash ^= Timestamp.GetHashCode();
    hash ^= Data.GetHashCode();
    if (_unknownFields != null) {
      hash ^= _unknownFields.GetHashCode();
    }
    return hash;
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public override string ToString() {
    return pb::JsonFormatter.ToDiagnosticString(this);
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public void WriteTo(pb::CodedOutputStream output) {
  #if !GOOGLE_PROTOBUF_REFSTRUCT_COMPATIBILITY_MODE
    output.WriteRawMessage(this);
  #else
    if (Key.Length != 0) {
      output.WriteRawTag(10);
      output.WriteString(Key);
    }
    if (Timestamp != 0L) {
      output.WriteRawTag(16);
      output.WriteInt64(Timestamp);
    }
    data_.WriteTo(output, _map_data_codec);
    if (_unknownFields != null) {
      _unknownFields.WriteTo(output);
    }
  #endif
  }

  #if !GOOGLE_PROTOBUF_REFSTRUCT_COMPATIBILITY_MODE
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  void pb::IBufferMessage.InternalWriteTo(ref pb::WriteContext output) {
    if (Key.Length != 0) {
      output.WriteRawTag(10);
      output.WriteString(Key);
    }
    if (Timestamp != 0L) {
      output.WriteRawTag(16);
      output.WriteInt64(Timestamp);
    }
    data_.WriteTo(ref output, _map_data_codec);
    if (_unknownFields != null) {
      _unknownFields.WriteTo(ref output);
    }
  }
  #endif

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public int CalculateSize() {
    int size = 0;
    if (Key.Length != 0) {
      size += 1 + pb::CodedOutputStream.ComputeStringSize(Key);
    }
    if (Timestamp != 0L) {
      size += 1 + pb::CodedOutputStream.ComputeInt64Size(Timestamp);
    }
    size += data_.CalculateSize(_map_data_codec);
    if (_unknownFields != null) {
      size += _unknownFields.CalculateSize();
    }
    return size;
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public void MergeFrom(SentBodyModel other) {
    if (other == null) {
      return;
    }
    if (other.Key.Length != 0) {
      Key = other.Key;
    }
    if (other.Timestamp != 0L) {
      Timestamp = other.Timestamp;
    }
    data_.Add(other.data_);
    _unknownFields = pb::UnknownFieldSet.MergeFrom(_unknownFields, other._unknownFields);
  }

  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  public void MergeFrom(pb::CodedInputStream input) {
  #if !GOOGLE_PROTOBUF_REFSTRUCT_COMPATIBILITY_MODE
    input.ReadRawMessage(this);
  #else
    uint tag;
    while ((tag = input.ReadTag()) != 0) {
      switch(tag) {
        default:
          _unknownFields = pb::UnknownFieldSet.MergeFieldFrom(_unknownFields, input);
          break;
        case 10: {
          Key = input.ReadString();
          break;
        }
        case 16: {
          Timestamp = input.ReadInt64();
          break;
        }
        case 26: {
          data_.AddEntriesFrom(input, _map_data_codec);
          break;
        }
      }
    }
  #endif
  }

  #if !GOOGLE_PROTOBUF_REFSTRUCT_COMPATIBILITY_MODE
  [global::System.Diagnostics.DebuggerNonUserCodeAttribute]
  [global::System.CodeDom.Compiler.GeneratedCode("protoc", null)]
  void pb::IBufferMessage.InternalMergeFrom(ref pb::ParseContext input) {
    uint tag;
    while ((tag = input.ReadTag()) != 0) {
      switch(tag) {
        default:
          _unknownFields = pb::UnknownFieldSet.MergeFieldFrom(_unknownFields, ref input);
          break;
        case 10: {
          Key = input.ReadString();
          break;
        }
        case 16: {
          Timestamp = input.ReadInt64();
          break;
        }
        case 26: {
          data_.AddEntriesFrom(ref input, _map_data_codec);
          break;
        }
      }
    }
  }
  #endif

}

#endregion


#endregion Designer generated code
