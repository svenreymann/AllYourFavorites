import React, { useContext } from 'react';
import styled from 'styled-components/macro';
import FavoriteContext from '../contexts/FavoriteContext';
import OpenMenuContext from '../contexts/OpenMenuContext';

export default function SoccerTeam({ soccerTeam }) {
  const { createFavorite } = useContext(FavoriteContext);
  const { open, setOpen } = useContext(OpenMenuContext);

  return (
    <SoccerTeamStyled onClick={() => handleClick(soccerTeam.teamId)}>
      <LogoStyled src={soccerTeam.crestUrl} alt="Team Logo" />
      {soccerTeam.name}
    </SoccerTeamStyled>
  );

  function handleClick(teamId) {
    createFavorite(teamId);
    setOpen(!open);
  }
}

const LogoStyled = styled.img`
  height: 1.2rem;
  padding-right: var(--size-s);
`;

const SoccerTeamStyled = styled.button`
  display: flex;
  justify-content: start;
  align-items: center;
  width: 200px;
  border: none;
  background: none;
  border-radius: var(--border-radius);
  transition: background var(--speed);
  color: var(--blue-main);
  font-size: var(--size-m);
  text-decoration: none;

  &:hover {
    background-color: lightgrey;
  }
`;
