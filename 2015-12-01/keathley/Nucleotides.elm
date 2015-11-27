module Nucleotides where

import Html exposing (..)
import Html.Attributes exposing (..)
import Html.Events exposing (..)
import Signal exposing (Address)
import StartApp.Simple as StartApp
import String exposing (split)
import Debug

-- Model

type Action = NoOp
            | UpdateNucleotideInput String
            | Count

type alias Nucleotide = String

type alias Model =
  {
    nInput: String
  , a: Int
  , c: Int
  , g: Int
  , t: Int
  }

initialModel : Model
initialModel =
  Model "" 0 0 0 0

update : Action -> Model -> Model
update action model =
  case action of
    NoOp ->
      model

    UpdateNucleotideInput value ->
      {model | nInput = value}

    Count ->
      countNucleotides (split "" model.nInput) {model | a=0, c=0, g=0, t=0}

countNucleotides ns model =
  case ns of
    [] ->
      model

    first :: rest ->
      countNucleotides rest (incr model first)

incr : Model -> Nucleotide -> Model
incr model nucl =
  case nucl of
    "A" -> {model | a=model.a+1}
    "C" -> {model | c=model.c+1}
    "G" -> {model | g=model.g+1}
    "T" -> {model | t=model.t+1}
    _   -> model


-- View

onInput : Address a -> (String -> a) -> Attribute
onInput address f =
  on "input" targetValue (\v -> Signal.message address (f v))

pageHeader : Html
pageHeader =
  h1 [ class "header" ]
    [ text "Nucleotide" ]

handleEnterKey : Int -> Action
handleEnterKey num =
  case num of
    13 -> Count
    _  -> NoOp

nucleotideForm : Address Action -> Model -> Html
nucleotideForm address model =
  div [ class "form" ]
    [ input
      [ type' "text"
      , placeholder "Enter string"
      , value model.nInput
      , name "string"
      , autofocus True
      , class "input"
      , onKeyDown address handleEnterKey
      , onInput address UpdateNucleotideInput ]
      [ ]
    , button [ class "btn", onClick address Count ] [ text "Count" ]]

symbolCount : String -> Int -> Html
symbolCount char num =
  div
    [ class "nucleotide" ]
    [ div [ class "legend" ] [ text char ]
    , div [ class "count"] [ text (toString num) ] ]

symbolCounts : Model -> Html
symbolCounts model =
  div
    [ class "nucleotides" ]
    [ symbolCount "A" model.a
    , symbolCount "C" model.c
    , symbolCount "G" model.g
    , symbolCount "T" model.t ]

view : Address Action -> Model -> Html
view address model =
  div
    [ class "app" ]
    [ pageHeader
    , nucleotideForm address model
    , symbolCounts model]

main : Signal Html
main =
  StartApp.start
  { model=initialModel, view=view, update=update }
